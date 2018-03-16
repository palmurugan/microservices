import { Component, Input } from '@angular/core';
var QueryBuilderComponent = /** @class */ (function () {
    function QueryBuilderComponent() {
        this.data = { condition: 'and', rules: [] };
        this.config = { fields: {} };
        this.defaultEmptyList = [];
        this.typeMap = {
            string: 'text',
            number: 'number',
            category: 'select',
            date: 'date',
            boolean: 'checkbox'
        };
        this.operatorMap = {
            string: ['=', '!=', 'contains', 'like'],
            number: ['=', '!=', '>', '>=', '<', '<='],
            category: ['=', '!='],
            date: ['=', '!=', '>', '>=', '<', '<='],
            boolean: ['=']
        };
    }
    QueryBuilderComponent.prototype.ngOnInit = function () {
    };
    QueryBuilderComponent.prototype.ngOnChanges = function (changes) {
        var config = this.config;
        if (typeof config === 'object') {
			if(!config.fields) {
				return;
			}
            this.fieldNames = Object.keys(config.fields);
            this.operatorsCache = {};
        }
        else {
            throw new Error('config must be a valid object');
        }
    };
    QueryBuilderComponent.prototype.getOperators = function (field) {
		if(!this.operatorsCache || !this.config.fields) {
			return;
		}
        if (this.operatorsCache[field]) {
            return this.operatorsCache[field];
        }
        var operators = this.defaultEmptyList;
        if (this.config.getOperators) {
            operators = this.config.getOperators(field);
        }
        var fieldObject = this.config.fields[field];
        var type = fieldObject.type;
        if (field && this.operatorMap[type]) {
            operators = this.operatorMap[type];
        }
        if (fieldObject.options) {
            operators = operators.concat(['in', 'not in']);
        }
        if (fieldObject.nullable) {
            operators = operators.concat(['is null', 'is not null']);
        }
        // Cache reference to array object, so it won't be computed next time and trigger a rerender.
        this.operatorsCache[field] = operators;
        return operators;
    };
    QueryBuilderComponent.prototype.getInputType = function (field, operator) {
        if (this.config.getInputType) {
            return this.config.getInputType(field, operator);
        }
		if(!this.config.fields) {
			return;
		}
        var type = this.config.fields[field].type;
        switch (operator) {
            case 'is null':
            case 'is not null':
                return null; // No displayed component
            case 'in':
            case 'not in':
                return 'multiselect';
            default:
                return this.typeMap[type];
        }
    };
    QueryBuilderComponent.prototype.getOptions = function (field) {
        if (this.config.getOptions) {
            return this.config.getOptions(field);
        }
        return this.config.fields[field].options || this.defaultEmptyList;
    };
    QueryBuilderComponent.prototype.addRule = function (parent) {
        if (this.config.addRule) {
            return this.config.addRule(parent);
        }
        else {
            var field = this.fieldNames[0];
            var fieldObject = this.config.fields[field];
            parent.rules = parent.rules.concat([
                {
                    field: field,
                    operator: this.operatorMap[fieldObject.type][0]
                }
            ]);
        }
    };
    QueryBuilderComponent.prototype.removeRule = function (rule, parent) {
        if (this.config.removeRule) {
            this.config.removeRule(rule, parent);
        }
        else {
            parent.rules = parent.rules.filter(function (r) { return r !== rule; });
        }
    };
    QueryBuilderComponent.prototype.addRuleSet = function (parent) {
        if (this.config.addRuleSet) {
            this.config.addRuleSet(parent);
        }
        else {
            parent.rules = parent.rules.concat([{ condition: 'and', rules: [] }]);
        }
    };
    QueryBuilderComponent.prototype.removeRuleSet = function (ruleset, parent) {
        if (this.config.removeRuleSet) {
            this.config.removeRuleSet(ruleset, parent);
        }
        else {
            parent.rules = parent.rules.filter(function (r) { return r !== ruleset; });
        }
    };
    QueryBuilderComponent.prototype.onFieldChange = function (rule) {
        delete rule.value;
        var fieldObject = this.config.fields[rule.field];
        rule.operator = this.operatorMap[fieldObject.type][0];
    };
    QueryBuilderComponent.decorators = [
        { type: Component, args: [{
                    selector: 'query-builder',
                    template: "\n    <div class=\"switch-field float-right\">\n        <button (click)=\"addRule(data)\"><i class=\"close-icon\">\u2795</i> Rule</button>\n        <button (click)=\"addRuleSet(data)\"><i class=\"close-icon\">\u2795</i> Ruleset</button>\n        <ng-container *ngIf=\"!!parentData\">\n            <button (click)=\"removeRuleSet(data, parentData)\" class=\"danger\"><i class=\"close-icon\">\u274C</i></button>\n        </ng-container>\n    </div>\n\n    <div class=\"switch-field\">\n        <input type=\"radio\" [(ngModel)]=\"data.condition\" value=\"and\" #andOption/>\n        <label (click)=\"data.condition=andOption.value\">AND</label>\n        <input type=\"radio\" [(ngModel)]=\"data.condition\" value=\"or\" #orOption/>\n        <label (click)=\"data.condition=orOption.value\">OR</label>\n    </div>\n\n    <ul class=\"query-tree\">\n      <ng-container *ngFor=\"let item of data.rules\">\n        <ng-container *ngIf=\"{ruleset: !!item.rules, invalid: !config.allowEmptyRuleset && item.rules && item.rules.length === 0} as local\">\n          <li [ngClass]=\"{'query-item': true, 'rule': !local.ruleset, 'ruleset': local.ruleset, 'invalid-ruleset': local.invalid}\">\n            <ng-container *ngIf=\"!local.ruleset\">\n                <div class=\"switch-field float-right\">\n                  <button class=\"danger\" (click)=\"removeRule(item, data)\"><i class=\"close-icon\">\u274C</i></button>\n                </div>\n\n                <select class=\"form-control\" [(ngModel)]=\"item.field\" (change)=\"onFieldChange(item)\">\n                  <option *ngFor=\"let field of fieldNames\" [ngValue]=\"field\">\n                    {{config.fields[field].name}}\n                  </option>\n                </select>\n                <select class=\"form-control\" [(ngModel)]=\"item.operator\">\n                  <option *ngFor=\"let operator of getOperators(item.field)\" [ngValue]=\"operator\">\n                    {{operator}}\n                  </option>\n                </select>\n                <ng-container [ngSwitch]=\"getInputType(item.field, item.operator)\">\n                  <input class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'text'\" type=\"text\">\n                  <input class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'date'\" type=\"date\">\n                  <input class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'number'\" type=\"number\">\n                  <select class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'select'\">\n                    <option *ngFor=\"let opt of getOptions(item.field)\" [ngValue]=\"opt.value\">\n                      {{opt.name}}\n                    </option>\n                  </select>\n                  <ng-container *ngSwitchCase=\"'multiselect'\">\n                    <div style=\"margin-bottom: 8px\"></div>\n                    <select class=\"form-control\" [(ngModel)]=\"item.value\" style=\"min-width: 200px\" multiple>\n                      <option *ngFor=\"let opt of getOptions(item.field)\" [ngValue]=\"opt.value\">\n                        {{opt.name}}\n                      </option>\n                    </select>\n                  </ng-container>\n                  <input class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'checkbox'\" type=\"checkbox\">\n                </ng-container>\n            </ng-container>\n            <query-builder *ngIf=\"local.ruleset\" [data]=\"item\" [parentData]=\"data\" [config]=\"config\" [typeMap]=\"typeMap\" [operatorMap]=\"operatorMap\"></query-builder>\n            <p class=\"empty-warning\" *ngIf=\"local.invalid\">A ruleset cannot be empty. Please add a rule or remove it all together.</p>        \n          </li>\n        </ng-container>\n      </ng-container>\n    </ul>\n  ",
                    styles: ["\n    :host{display:block}:host .close-icon{font-style:normal;font-size:12px}:host .switch-field{font-family:\"Lucida Grande\", Tahoma, Verdana, sans-serif;overflow:hidden}:host .float-right{float:right}:host .switch-title{margin-bottom:6px}:host .form-control{display:inline-block;padding:4px 8px;color:#555;background-color:#fff;background-image:none;border:1px solid #ccc;border-radius:4px}:host .switch-field input{position:absolute;clip:rect(0, 0, 0, 0);height:1px;width:1px;border:0;overflow:hidden}:host .switch-field button{margin-left:8px;background-color:white}:host .switch-field label{background-color:#e4e4e4}:host .switch-field label,:host .switch-field button{float:left;min-width:30px;color:rgba(0,0,0,0.6);font-size:14px;font-weight:normal;text-align:center;text-shadow:none;padding:4px 8px;border:1px solid rgba(0,0,0,0.2);-webkit-transition:all 0.1s ease-in-out;-moz-transition:all 0.1s ease-in-out;-ms-transition:all 0.1s ease-in-out;-o-transition:all 0.1s ease-in-out;transition:all 0.1s ease-in-out}:host .switch-field label:hover,:host .switch-field button:hover{cursor:pointer;background-color:#F0F0F0}:host .switch-field label.success,:host .switch-field button.success{color:#75BE47}:host .switch-field label.danger,:host .switch-field button.danger{color:#B3415D}:host .switch-field input:checked+label{border:1px solid #619ed7;background:white;color:#3176b3}:host .invalid-ruleset{border:1px solid rgba(179,65,93,0.5) !important;background:rgba(179,65,93,0.1) !important}:host .empty-warning{color:#8d252e;text-align:center}:host .query-tree{list-style:none;margin:4px 0 2px}:host .query-tree .query-item{position:relative;padding:4px 6px;margin-top:4px;border:1px solid #CCCCCC;-webkit-transition:all 0.1s ease-in-out;-moz-transition:all 0.1s ease-in-out;-ms-transition:all 0.1s ease-in-out;-o-transition:all 0.1s ease-in-out;transition:all 0.1s ease-in-out}:host .query-tree .query-item.ruleset{background:rgba(204,204,204,0.2)}:host .query-tree .query-item.ruleset:hover{border:1px solid rgba(97,158,215,0.5);background:rgba(97,158,215,0.1)}:host .query-tree .query-item.rule{background:white}:host .query-tree .query-item::before{top:-5px;border-width:0 0 2px 2px}:host .query-tree .query-item::after{border-width:0 0 0 2px;top:50%}:host .query-tree .query-item::before,:host .query-tree .query-item::after{content:'';left:-12px;border-color:#CCC;border-style:solid;width:9px;height:calc(50% + 6px);position:absolute}:host .query-tree .query-item:last-child::after{content:none}\n  "]
                },] },
    ];
    /** @nocollapse */
    QueryBuilderComponent.ctorParameters = function () { return []; };
    QueryBuilderComponent.propDecorators = {
        'operatorMap': [{ type: Input },],
        'typeMap': [{ type: Input },],
        'parentData': [{ type: Input },],
        'data': [{ type: Input },],
        'config': [{ type: Input },],
    };
    return QueryBuilderComponent;
}());
export { QueryBuilderComponent };
//# sourceMappingURL=query-builder.component.js.map