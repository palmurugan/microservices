/**
 * angular2-query-builder - A modernized Angular 2+ query builder based on jquery QueryBuilder
 * @version v0.0.2
 * @author Zeb Zhao
 * @link https://github.com/zebzhao/Angular-QueryBuilder#readme
 * @license MIT
 */
(function webpackUniversalModuleDefinition(root, factory) {
	if(typeof exports === 'object' && typeof module === 'object')
		module.exports = factory(require("@angular/core"), require("@angular/common"), require("@angular/forms"));
	else if(typeof define === 'function' && define.amd)
		define(["@angular/core", "@angular/common", "@angular/forms"], factory);
	else if(typeof exports === 'object')
		exports["ticktock"] = factory(require("@angular/core"), require("@angular/common"), require("@angular/forms"));
	else
		root["ticktock"] = factory(root["ng"]["core"], root["ng"]["common"], root["ng"]["forms"]);
})(typeof self !== 'undefined' ? self : this, function(__WEBPACK_EXTERNAL_MODULE_1__, __WEBPACK_EXTERNAL_MODULE_10__, __WEBPACK_EXTERNAL_MODULE_11__) {
return /******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 2);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
__export(__webpack_require__(3));


/***/ }),
/* 1 */
/***/ (function(module, exports) {

module.exports = __WEBPACK_EXTERNAL_MODULE_1__;

/***/ }),
/* 2 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var components_1 = __webpack_require__(0);
exports.QueryBuilderComponent = components_1.QueryBuilderComponent;
var query_builder_module_1 = __webpack_require__(9);
exports.QueryBuilderModule = query_builder_module_1.QueryBuilderModule;


/***/ }),
/* 3 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
__export(__webpack_require__(4));


/***/ }),
/* 4 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__(1);
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
            this.fieldNames = Object.keys(config.fields);
            this.operatorsCache = {};
        }
        else {
            throw new Error('config must be a valid object');
        }
    };
    QueryBuilderComponent.prototype.getOperators = function (field) {
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
    __decorate([
        core_1.Input(),
        __metadata("design:type", Object)
    ], QueryBuilderComponent.prototype, "operatorMap", void 0);
    __decorate([
        core_1.Input(),
        __metadata("design:type", Object)
    ], QueryBuilderComponent.prototype, "typeMap", void 0);
    __decorate([
        core_1.Input(),
        __metadata("design:type", Object)
    ], QueryBuilderComponent.prototype, "parentData", void 0);
    __decorate([
        core_1.Input(),
        __metadata("design:type", Object)
    ], QueryBuilderComponent.prototype, "data", void 0);
    __decorate([
        core_1.Input(),
        __metadata("design:type", Object)
    ], QueryBuilderComponent.prototype, "config", void 0);
    QueryBuilderComponent = __decorate([
        core_1.Component({
            selector: 'query-builder',
            template: __webpack_require__(5),
            styles: [__webpack_require__(6)]
        }),
        __metadata("design:paramtypes", [])
    ], QueryBuilderComponent);
    return QueryBuilderComponent;
}());
exports.QueryBuilderComponent = QueryBuilderComponent;


/***/ }),
/* 5 */
/***/ (function(module, exports) {

module.exports = "<div class=\"switch-field float-right\">\r\n    <button (click)=\"addRule(data)\"><i class=\"close-icon\">➕</i> Rule</button>\r\n    <button (click)=\"addRuleSet(data)\"><i class=\"close-icon\">➕</i> Ruleset</button>\r\n    <ng-container *ngIf=\"!!parentData\">\r\n        <button (click)=\"removeRuleSet(data, parentData)\" class=\"danger\"><i class=\"close-icon\">❌</i></button>\r\n    </ng-container>\r\n</div>\r\n\r\n<div class=\"switch-field\">\r\n    <input type=\"radio\" [(ngModel)]=\"data.condition\" value=\"and\" #andOption/>\r\n    <label (click)=\"data.condition=andOption.value\">AND</label>\r\n    <input type=\"radio\" [(ngModel)]=\"data.condition\" value=\"or\" #orOption/>\r\n    <label (click)=\"data.condition=orOption.value\">OR</label>\r\n</div>\r\n\r\n<ul class=\"query-tree\">\r\n  <ng-container *ngFor=\"let item of data.rules\">\r\n    <ng-container *ngIf=\"{ruleset: !!item.rules, invalid: !config.allowEmptyRuleset && item.rules && item.rules.length === 0} as local\">\r\n      <li [ngClass]=\"{'query-item': true, 'rule': !local.ruleset, 'ruleset': local.ruleset, 'invalid-ruleset': local.invalid}\">\r\n        <ng-container *ngIf=\"!local.ruleset\">\r\n            <div class=\"switch-field float-right\">\r\n              <button class=\"danger\" (click)=\"removeRule(item, data)\"><i class=\"close-icon\">❌</i></button>\r\n            </div>\r\n\r\n            <select class=\"form-control\" [(ngModel)]=\"item.field\" (change)=\"onFieldChange(item)\">\r\n              <option *ngFor=\"let field of fieldNames\" [ngValue]=\"field\">\r\n                {{config.fields[field].name}}\r\n              </option>\r\n            </select>\r\n            <select class=\"form-control\" [(ngModel)]=\"item.operator\">\r\n              <option *ngFor=\"let operator of getOperators(item.field)\" [ngValue]=\"operator\">\r\n                {{operator}}\r\n              </option>\r\n            </select>\r\n            <ng-container [ngSwitch]=\"getInputType(item.field, item.operator)\">\r\n              <input class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'text'\" type=\"text\">\r\n              <input class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'date'\" type=\"date\">\r\n              <input class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'number'\" type=\"number\">\r\n              <select class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'select'\">\r\n                <option *ngFor=\"let opt of getOptions(item.field)\" [ngValue]=\"opt.value\">\r\n                  {{opt.name}}\r\n                </option>\r\n              </select>\r\n              <ng-container *ngSwitchCase=\"'multiselect'\">\r\n                <div style=\"margin-bottom: 8px\"></div>\r\n                <select class=\"form-control\" [(ngModel)]=\"item.value\" style=\"min-width: 200px\" multiple>\r\n                  <option *ngFor=\"let opt of getOptions(item.field)\" [ngValue]=\"opt.value\">\r\n                    {{opt.name}}\r\n                  </option>\r\n                </select>\r\n              </ng-container>\r\n              <input class=\"form-control\" [(ngModel)]=\"item.value\" *ngSwitchCase=\"'checkbox'\" type=\"checkbox\">\r\n            </ng-container>\r\n        </ng-container>\r\n        <query-builder *ngIf=\"local.ruleset\" [data]=\"item\" [parentData]=\"data\" [config]=\"config\" [typeMap]=\"typeMap\" [operatorMap]=\"operatorMap\"></query-builder>\r\n        <p class=\"empty-warning\" *ngIf=\"local.invalid\">A ruleset cannot be empty. Please add a rule or remove it all together.</p>        \r\n      </li>\r\n    </ng-container>\r\n  </ng-container>\r\n</ul>"

/***/ }),
/* 6 */
/***/ (function(module, exports, __webpack_require__) {


        var result = __webpack_require__(7);

        if (typeof result === "string") {
            module.exports = result;
        } else {
            module.exports = result.toString();
        }
    

/***/ }),
/* 7 */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(8)(undefined);
// imports


// module
exports.push([module.i, ":host {\n  display: block; }\n  :host .close-icon {\n    font-style: normal;\n    font-size: 12px; }\n  :host .switch-field {\n    font-family: \"Lucida Grande\", Tahoma, Verdana, sans-serif;\n    overflow: hidden; }\n  :host .float-right {\n    float: right; }\n  :host .switch-title {\n    margin-bottom: 6px; }\n  :host .form-control {\n    display: inline-block;\n    padding: 4px 8px;\n    color: #555;\n    background-color: #fff;\n    background-image: none;\n    border: 1px solid #ccc;\n    border-radius: 4px; }\n  :host .switch-field input {\n    position: absolute;\n    clip: rect(0, 0, 0, 0);\n    height: 1px;\n    width: 1px;\n    border: 0;\n    overflow: hidden; }\n  :host .switch-field button {\n    margin-left: 8px;\n    background-color: white; }\n  :host .switch-field label {\n    background-color: #e4e4e4; }\n  :host .switch-field label, :host .switch-field button {\n    float: left;\n    min-width: 30px;\n    color: rgba(0, 0, 0, 0.6);\n    font-size: 14px;\n    font-weight: normal;\n    text-align: center;\n    text-shadow: none;\n    padding: 4px 8px;\n    border: 1px solid rgba(0, 0, 0, 0.2);\n    -webkit-transition: all 0.1s ease-in-out;\n    -moz-transition: all 0.1s ease-in-out;\n    -ms-transition: all 0.1s ease-in-out;\n    -o-transition: all 0.1s ease-in-out;\n    transition: all 0.1s ease-in-out; }\n    :host .switch-field label:hover, :host .switch-field button:hover {\n      cursor: pointer;\n      background-color: #F0F0F0; }\n    :host .switch-field label.success, :host .switch-field button.success {\n      color: #75BE47; }\n    :host .switch-field label.danger, :host .switch-field button.danger {\n      color: #B3415D; }\n  :host .switch-field input:checked + label {\n    border: 1px solid #619ed7;\n    background: white;\n    color: #3176b3; }\n  :host .invalid-ruleset {\n    border: 1px solid rgba(179, 65, 93, 0.5) !important;\n    background: rgba(179, 65, 93, 0.1) !important; }\n  :host .empty-warning {\n    color: #8d252e;\n    text-align: center; }\n  :host .query-tree {\n    list-style: none;\n    margin: 4px 0 2px; }\n    :host .query-tree .query-item {\n      position: relative;\n      padding: 4px 6px;\n      margin-top: 4px;\n      border: 1px solid #CCCCCC;\n      -webkit-transition: all 0.1s ease-in-out;\n      -moz-transition: all 0.1s ease-in-out;\n      -ms-transition: all 0.1s ease-in-out;\n      -o-transition: all 0.1s ease-in-out;\n      transition: all 0.1s ease-in-out; }\n      :host .query-tree .query-item.ruleset {\n        background: rgba(204, 204, 204, 0.2); }\n        :host .query-tree .query-item.ruleset:hover {\n          border: 1px solid rgba(97, 158, 215, 0.5);\n          background: rgba(97, 158, 215, 0.1); }\n      :host .query-tree .query-item.rule {\n        background: white; }\n      :host .query-tree .query-item::before {\n        top: -5px;\n        border-width: 0 0 2px 2px; }\n      :host .query-tree .query-item::after {\n        border-width: 0 0 0 2px;\n        top: 50%; }\n      :host .query-tree .query-item::before, :host .query-tree .query-item::after {\n        content: '';\n        left: -12px;\n        border-color: #CCC;\n        border-style: solid;\n        width: 9px;\n        height: calc(50% + 6px);\n        position: absolute; }\n      :host .query-tree .query-item:last-child::after {\n        content: none; }\n", ""]);

// exports


/***/ }),
/* 8 */
/***/ (function(module, exports) {

/*
	MIT License http://www.opensource.org/licenses/mit-license.php
	Author Tobias Koppers @sokra
*/
// css base code, injected by the css-loader
module.exports = function(useSourceMap) {
	var list = [];

	// return the list of modules as css string
	list.toString = function toString() {
		return this.map(function (item) {
			var content = cssWithMappingToString(item, useSourceMap);
			if(item[2]) {
				return "@media " + item[2] + "{" + content + "}";
			} else {
				return content;
			}
		}).join("");
	};

	// import a list of modules into the list
	list.i = function(modules, mediaQuery) {
		if(typeof modules === "string")
			modules = [[null, modules, ""]];
		var alreadyImportedModules = {};
		for(var i = 0; i < this.length; i++) {
			var id = this[i][0];
			if(typeof id === "number")
				alreadyImportedModules[id] = true;
		}
		for(i = 0; i < modules.length; i++) {
			var item = modules[i];
			// skip already imported module
			// this implementation is not 100% perfect for weird media query combinations
			//  when a module is imported multiple times with different media queries.
			//  I hope this will never occur (Hey this way we have smaller bundles)
			if(typeof item[0] !== "number" || !alreadyImportedModules[item[0]]) {
				if(mediaQuery && !item[2]) {
					item[2] = mediaQuery;
				} else if(mediaQuery) {
					item[2] = "(" + item[2] + ") and (" + mediaQuery + ")";
				}
				list.push(item);
			}
		}
	};
	return list;
};

function cssWithMappingToString(item, useSourceMap) {
	var content = item[1] || '';
	var cssMapping = item[3];
	if (!cssMapping) {
		return content;
	}

	if (useSourceMap && typeof btoa === 'function') {
		var sourceMapping = toComment(cssMapping);
		var sourceURLs = cssMapping.sources.map(function (source) {
			return '/*# sourceURL=' + cssMapping.sourceRoot + source + ' */'
		});

		return [content].concat(sourceURLs).concat([sourceMapping]).join('\n');
	}

	return [content].join('\n');
}

// Adapted from convert-source-map (MIT)
function toComment(sourceMap) {
	// eslint-disable-next-line no-undef
	var base64 = btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap))));
	var data = 'sourceMappingURL=data:application/json;charset=utf-8;base64,' + base64;

	return '/*# ' + data + ' */';
}


/***/ }),
/* 9 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__(1);
var common_1 = __webpack_require__(10);
var forms_1 = __webpack_require__(11);
var components_1 = __webpack_require__(0);
var QueryBuilderModule = /** @class */ (function () {
    function QueryBuilderModule() {
    }
    QueryBuilderModule = __decorate([
        core_1.NgModule({
            imports: [
                common_1.CommonModule,
                forms_1.FormsModule
            ],
            declarations: [
                components_1.QueryBuilderComponent
            ],
            exports: [
                components_1.QueryBuilderComponent
            ]
        })
    ], QueryBuilderModule);
    return QueryBuilderModule;
}());
exports.QueryBuilderModule = QueryBuilderModule;


/***/ }),
/* 10 */
/***/ (function(module, exports) {

module.exports = __WEBPACK_EXTERNAL_MODULE_10__;

/***/ }),
/* 11 */
/***/ (function(module, exports) {

module.exports = __WEBPACK_EXTERNAL_MODULE_11__;

/***/ })
/******/ ]);
});
//# sourceMappingURL=index.umd.js.map