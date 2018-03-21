grammar GameField;

game:
    (name WS? level WS?)*;

name:
    NAME_LABEL DESIGNATE_SYMBOL STRING_VALUE;

level:
    LEVEL_LABEL DESIGNATE_SYMBOL INT_VALUE;

DESIGNATE_SYMBOL: WS? ':' WS? ;

NAME_LABEL: 'name' ;
LEVEL_LABEL: 'level' ;
INT_VALUE: DIGIT+ ;
STRING_VALUE: (CHAR|DIGIT)+ ;
CHAR : [a-zA-Z];
DIGIT : [0-9];
WS: [\r\n\t| ]+ -> skip ;