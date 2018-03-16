import { OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { Option, QueryBuilderConfig, Rule, RuleSet } from './query-builder.interfaces';
export declare class QueryBuilderComponent implements OnInit, OnChanges {
    fieldNames: string[];
    operatorMap: {
        [key: string]: string[];
    };
    typeMap: {
        [key: string]: string;
    };
    parentData: RuleSet;
    data: RuleSet;
    config: QueryBuilderConfig;
    private defaultEmptyList;
    private operatorsCache;
    constructor();
    ngOnInit(): void;
    ngOnChanges(changes: SimpleChanges): void;
    getOperators(field: string): string[];
    getInputType(field: string, operator: string): string;
    getOptions(field: string): Option[];
    addRule(parent: RuleSet): void;
    removeRule(rule: Rule, parent: RuleSet): void;
    addRuleSet(parent: RuleSet): void;
    removeRuleSet(ruleset: RuleSet, parent: RuleSet): void;
    onFieldChange(rule: Rule): void;
}
