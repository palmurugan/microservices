import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, } from '@angular/forms';
import { QueryBuilderComponent } from './components';
var QueryBuilderModule = /** @class */ (function () {
    function QueryBuilderModule() {
    }
    QueryBuilderModule.decorators = [
        { type: NgModule, args: [{
                    imports: [
                        CommonModule,
                        FormsModule
                    ],
                    declarations: [
                        QueryBuilderComponent
                    ],
                    exports: [
                        QueryBuilderComponent
                    ]
                },] },
    ];
    /** @nocollapse */
    QueryBuilderModule.ctorParameters = function () { return []; };
    return QueryBuilderModule;
}());
export { QueryBuilderModule };
//# sourceMappingURL=query-builder.module.js.map