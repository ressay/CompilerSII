grammar TinyLangageSII;

@lexer::members {
@Override
  public void recover(RecognitionException ex)
  {
    System.out.println("something!!");
    throw new RuntimeException(ex.getMessage());
  }
}

prog : 'compil' ID '(' ')' '{' declarations START insts '}' ;
declarations : (dec declarations)|dec  ;
dec : type vars ';' ;
type : INT | FLOAT;
vars : ((ID ',' vars) | ID) ;
identifier : ID;
val : INTEGERVAL | FLOATVAL;
insts : (inst ';' insts) | inst ';' ;
inst : affect | ifinst | read | write;
affect : identifier '=' exp ;
exp : exp opmi t | t;
t : t opma endEx | endEx;
opmi : PLUS | MINUS ;
opma : MUL | DIV ;
endEx : identifier | '(' exp ')' | val ;

ifinst : IF '(' comp ')' THEN insts (|el insts)  ENDIF;
el : ELSE;
comp : exp op exp ;
op : SUP | INF | SUPE | INFE | DIF | EQ;

read :  SCAN '(' listID ')' ;
write : PRINT '(' (STR|listID) ')' ;
listID : identifier ',' listID | identifier ;





INT : 'intCompil';
FLOAT : 'floatCompil';
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
SUPE : '>=';
INFE : '<=';
EQ : '==';
DIF : '!=';
INTEGERVAL : '0'|[+-]?[1-9][0-9]* ;
FLOATVAL : '0'|[+-]?[1-9][0-9]*('.'[0-9]*) ;
WHITESPACE : [ \n\t] -> skip;
ONELINE : '/''/'(~[\n])* -> skip;
STR : '"'(~["]|'\\"')*'"';
