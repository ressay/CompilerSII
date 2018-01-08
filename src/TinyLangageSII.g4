grammar TinyLangageSII;

// analyseur syntaxique
prog : COMPIL ID '(' ')' '{' declarations START insts '}' ;

// déclaration
declarations : (dec declarations)|dec  ;
dec : type vars ';' ;
type : INT | FLOAT;
vars : ((ID ',' vars) | ID) ;
identifier : ID;

// instructions
insts : (inst ';' insts) | inst ';' ;
inst : affect | ifinst | read | write;

// affectation
affect : identifier AFF exp ;
exp : exp opmi t | t;
t : t opma endEx | endEx;
opmi : PLUS | MINUS ;
opma : MUL | DIV ;
endEx : identifier | '(' exp ')' | val ;
val : INTEGERVAL | FLOATVAL;

// instruction if
ifinst : IF '(' comp ')' THEN insts (|el insts)  ENDIF;
el : ELSE;
comp : exp op exp ;
op : SUP | INF | SUPE | INFE | DIF | EQ;

// instruction read/write
read :  SCAN '(' listID ')' ;
write : PRINT '(' (STR|listID) ')' ;
listID : identifier ',' listID | identifier ;


//******************* Key Words *******************//

COMPIL : 'compil';
INT : 'intCompil';
FLOAT : 'floatCompil';
SCAN : 'scancompil' ;
PRINT : 'printcompil' ;
START : 'start' ;
IF : 'if';
THEN : 'then';
ELSE : 'else';
ENDIF : 'endif';



//******************* Operators *******************//

AFF : '=';
PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';
SUP : '>';
INF : '<';
SUPE : '>=';
INFE : '<=';
EQ : '==';
DIF : '!=';

//******************* Regular Expressions *******************//

ID : [a-zA-Z][a-zA-Z0-9]*;
INTEGERVAL : '0'|[+-]?[1-9][0-9]*;
FLOATVAL : '0'|[+-]?[1-9][0-9]*('.'[0-9]*);
STR : '"'(~["]|'\\"')*'"';


//******************* To Skip *******************//


WHITESPACE : [ \n\t] -> skip;
ONELINE : '/''/'(~[\n])* -> skip;
MULLINE : '/*'(.)*?'*/' -> skip;

