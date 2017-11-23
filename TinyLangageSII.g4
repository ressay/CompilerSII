grammar TinyLangageSII;

prog : 'compil' ID '(' ')' '{' dec START insts '}' | ;
dec : type vars ';' ;
type : INT | FLOAT;
val : INTEGERVAL | FLOATVAL;
vars : ((ID ',' vars) | ID) ;
insts : (inst ';' insts) | inst ';' ;
inst : affect | ifinst | read | write;
affect : ID '=' exp ;
exp : t opmi exp | t;
t : endEx opma t | endEx;
opmi : PLUS | MINUS ;
opma : MUL | DIV ;
endEx : ID | '(' exp ')' | val ;

ifinst : IF '(' comp ')' THEN insts (|ELSE insts)  ENDIF;

comp : exp op exp ;
op : SUP | INF ;

read :  SCAN '(' listID ')' ;
write : PRINT '(' STR ')' ;
listID : ID ',' listID | ID ;

INT : 'intCompil';
FLOAT : 'floatcompil';
SCAN : 'scancompil' ;
PRINT : 'printcompil' ;
START : 'start' ;
IF : 'if';
THEN : 'then';
ELSE : 'else';
ENDIF : 'endif';
ID : [a-zA-Z][a-zA-Z0-9]*;
PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';
SUP : '>';
INF : '<';
INTEGERVAL : '0'|[+-]?[1-9][0-9]* ;
FLOATVAL : '0'|[+-]?[1-9][0-9]*('.'[0-9]*) ;
WHITESPACE : [ \n\t] -> skip;
STR : '"'(~["]|'\\"')*'"';
