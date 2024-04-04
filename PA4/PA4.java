/* Generated By:JavaCC: Do not edit this line. PA4.java */
import syntaxtree.*;

public class PA4 implements PA4Constants {

  /** Main entry point. */
  public static void main(String args[]) {
    PA4 t = new PA4(System.in);
    try {
      Program n = t.Start();

 //uncomment this only for PA4a
 /*     System.out.println("\n\nPretty Printing the Abstract Syntax Tree");
      Visitor v1 = new AST_Visitor();  // pretty prints the Abstract Syntax Tree
      n.accept(v1, 0);f
*/

 //uncomment this only for PA4b
      System.out.println("\n\nPretty Print the Program");
      Visitor v2 = new PP_Visitor();  // pretty prints the MiniJ program
      String s = (String) n.accept(v2, 0);
      System.out.println(s);


/* uncomment this only for MiniC2Pascal translator
      //System.out.println("\n\nPretty Print the Program");
      Visitor v2 = new Pascal_Visitor();  // pretty prints the MiniC program
      String s = (String) n.accept(v2, 0);
      System.out.println("PROGRAM Demo;\n");
      System.out.println(s);
      System.out.println("BEGIN\n main(1);\nEND.");
*/

// uncomment this only for PA4c and PA4d
  /*    System.out.println("\n\nGenerating Symbol Table");
      SymbolTableVisitor v3 = new SymbolTableVisitor(); // generates a SymbolTable
      SymbolTable st = v3.symbolTable;
      n.accept(v3,"");
      System.out.println(st);
*/
// uncomment this only for PA4d  
 /*     System.out.println("\n\nType Checking");
      TypeCheckingVisitor v4 = new TypeCheckingVisitor(st);
      n.accept(v4,"");
      System.out.println(v4.num_errors+" type errors found");

      System.out.println("\n\nDone!");
*/
    } catch (Exception e) {
      System.out.println("Oops.");
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

/* Program Syntax */
  static final public Program Start() throws ParseException {
  MainClass m;
  ClassDeclList c;
    m = MainClass();
    c = ClassDecls();
   {if (true) return new Program(m,c);}
    jj_consume_token(0);
    throw new Error("Missing return statement in function");
  }

  static final public MainClass MainClass() throws ParseException {
  Token t;
  Statement s;
    jj_consume_token(CLASS);
    t = jj_consume_token(ID);
    jj_consume_token(LCURLY);
    jj_consume_token(PUBLIC);
    jj_consume_token(STATIC);
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(LPAREN);
    jj_consume_token(STRING);
    jj_consume_token(LBRACKET);
    jj_consume_token(RBRACKET);
    jj_consume_token(ID);
    jj_consume_token(RPAREN);
    jj_consume_token(LCURLY);
    s = Statement();
    jj_consume_token(RCURLY);
    jj_consume_token(RCURLY);
   {if (true) return (new MainClass(new Identifier(t.image),s));}
    throw new Error("Missing return statement in function");
  }

  static final public ClassDeclList ClassDecls() throws ParseException {
  ClassDeclList clist = null;
  ClassDecl c;
    label_1:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_1;
      }
      c = ClassDecl();
        clist = new ClassDeclList(c,clist);
    }
   {if (true) return(clist);}
    throw new Error("Missing return statement in function");
  }

  static final public ClassDecl ClassDecl() throws ParseException {
  Token t;
  VarDeclList v;
  MethodDeclList m;
    if (jj_2_2(2)) {
      jj_consume_token(CLASS);
      t = jj_consume_token(ID);
      jj_consume_token(LCURLY);
      v = VarDecls();
      m = MethodDecls();
      jj_consume_token(RCURLY);
   {if (true) return (new ClassDecl(new Identifier(t.image),v,m));}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLASS:
        jj_consume_token(CLASS);
        t = jj_consume_token(ID);
        jj_consume_token(EXTENDS);
        jj_consume_token(ID);
        jj_consume_token(LCURLY);
        v = VarDecls();
        m = MethodDecls();
        jj_consume_token(RCURLY);
   {if (true) return (new ClassDecl(new Identifier(t.image),v,m));}
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public VarDeclList VarDecls() throws ParseException {
  VarDeclList vlist = null;
  VarDecl v;
    label_2:
    while (true) {
      if (jj_2_3(2)) {
        ;
      } else {
        break label_2;
      }
      v = VarDecl();
        vlist = new VarDeclList(v,vlist);
    }
     {if (true) return(vlist);}
    throw new Error("Missing return statement in function");
  }

  static final public VarDecl VarDecl() throws ParseException {
  Type ty;
  Token t;
    ty = Type();
    t = jj_consume_token(ID);
    jj_consume_token(SEMICOLON);
   {if (true) return(new VarDecl(ty,new Identifier(t.image)));}
    throw new Error("Missing return statement in function");
  }

  static final public Type Type() throws ParseException {
  Token t;
    if (jj_2_4(2)) {
      jj_consume_token(BOOLEAN);
   {if (true) return new BooleanType();}
    } else if (jj_2_5(2)) {
      jj_consume_token(INT);
      jj_consume_token(LBRACKET);
      jj_consume_token(RBRACKET);
   {if (true) return new IntArrayType();}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
        jj_consume_token(INT);
   {if (true) return new IntegerType();}
        break;
      case ID:
        t = jj_consume_token(ID);
   {if (true) return new IdentifierType(t.image);}
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public MethodDeclList MethodDecls() throws ParseException {
  MethodDeclList mlist = null;
  MethodDecl m;
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PUBLIC:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      m = MethodDecl();
        mlist = new MethodDeclList(m,mlist);
    }
   {if (true) return mlist;}
    throw new Error("Missing return statement in function");
  }

  static final public MethodDecl MethodDecl() throws ParseException {
  Type ty;
  Token t;
  FormalList flist;
  VarDeclList vlist;
  StatementList slist;
  Exp e;
    jj_consume_token(PUBLIC);
    ty = Type();
    t = jj_consume_token(ID);
    jj_consume_token(LPAREN);
    flist = FormalList();
    jj_consume_token(RPAREN);
    jj_consume_token(LCURLY);
    vlist = VarDecls();
    slist = Statements();
    jj_consume_token(RETURN);
    e = Exp();
    jj_consume_token(SEMICOLON);
    jj_consume_token(RCURLY);
   {if (true) return new MethodDecl(ty,new Identifier(t.image),flist,vlist,slist,e);}
    throw new Error("Missing return statement in function");
  }

  static final public FormalList FormalList() throws ParseException {
  FormalList flist=null;
  Formal f1,f2;
    f1 = Formal();
                 flist = new FormalList(f1,null);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      f2 = Formal();
     flist = new FormalList(f2,flist);
    }
   {if (true) return flist;}
    throw new Error("Missing return statement in function");
  }

  static final public Formal Formal() throws ParseException {
  Type ty;
  Token t;
    ty = Type();
    t = jj_consume_token(ID);
   {if (true) return new Formal(ty,new Identifier(t.image));}
    throw new Error("Missing return statement in function");
  }

  static final public StatementList Statements() throws ParseException {
  StatementList s_list = null;
  Statement s;
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case PRINTLN:
      case LCURLY:
      case ID:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_5;
      }
      s = Statement();
     s_list = new StatementList(s,s_list);
    }
    {if (true) return s_list;}
    throw new Error("Missing return statement in function");
  }

  static final public Statement Statement() throws ParseException {
  Token t;
  StatementList s_list;
  Exp e1,e2;
  Statement s1,s2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LCURLY:
      jj_consume_token(LCURLY);
      s_list = Statements();
      jj_consume_token(RCURLY);
   {if (true) return(new Block(s_list));}
      break;
    case IF:
      jj_consume_token(IF);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      s1 = Statement();
      jj_consume_token(ELSE);
      s2 = Statement();
   {if (true) return(new If(e1,s1,s2));}
      break;
    case PRINTLN:
      jj_consume_token(PRINTLN);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      jj_consume_token(SEMICOLON);
   {if (true) return(new Print(e1));}
      break;
    default:
      jj_la1[5] = jj_gen;
      if (jj_2_6(2)) {
        t = jj_consume_token(ID);
        jj_consume_token(EQUALS);
        e1 = Exp();
        jj_consume_token(SEMICOLON);
   {if (true) return(new Assign(new Identifier(t.image),e1));}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case WHILE:
          jj_consume_token(WHILE);
          jj_consume_token(LPAREN);
          e1 = Exp();
          jj_consume_token(RPAREN);
          s1 = Statement();
   {if (true) return new While(e1,s1);}
          break;
        case ID:
          t = jj_consume_token(ID);
          jj_consume_token(LBRACKET);
          e1 = Exp();
          jj_consume_token(RBRACKET);
          jj_consume_token(EQUALS);
          e2 = Exp();
          jj_consume_token(SEMICOLON);
   {if (true) return(new ArrayAssign(new Identifier(t.image),e1, e2));}
          break;
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp() throws ParseException {
 Exp a,b;
    a = Exp4();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_6;
      }
      jj_consume_token(AND);
      b = Exp4();
                            a = new And(a,b);
    }
   {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp4() throws ParseException {
 Exp a,b;
    a = Exp9();
    label_7:
    while (true) {
      if (jj_2_7(2)) {
        ;
      } else {
        break label_7;
      }
      jj_consume_token(LT);
      b = Exp9();
                               a = new LessThan(a,b);
    }
   {if (true) return(a);}
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp9() throws ParseException {
 Exp a,b;
    a = Exp11();
    label_8:
    while (true) {
      if (jj_2_8(2)) {
        ;
      } else {
        break label_8;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS_OP:
        jj_consume_token(PLUS_OP);
        b = Exp11();
                       a = new Plus(a,b);
        break;
      case MINUS_OP:
        jj_consume_token(MINUS_OP);
        b = Exp11();
                       a = new Minus(a,b);
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
   {if (true) return(a);}
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp11() throws ParseException {
 Exp a,b;
    a = Exp12();
    label_9:
    while (true) {
      if (jj_2_9(2)) {
        ;
      } else {
        break label_9;
      }
      jj_consume_token(TIMES_OP);
      b = Exp12();
     a = new Times(a,b);
    }
   {if (true) return(a);}
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp12() throws ParseException {
 Exp a,b;
 ExpList c,elist;
 Identifier i;
 Token t;
    a = Exp14();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DOT:
      case LBRACKET:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_10;
      }
      if (jj_2_10(3)) {
        jj_consume_token(DOT);
        i = Identifier();
        jj_consume_token(LPAREN);
        elist = ExpList();
        jj_consume_token(RPAREN);
         a = new Call(a,i,elist);
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DOT:
          jj_consume_token(DOT);
          jj_consume_token(LENGTH);
         {if (true) return new ArrayLength(a);}
          break;
        case LBRACKET:
          jj_consume_token(LBRACKET);
          b = Exp();
          jj_consume_token(RBRACKET);
         {if (true) return new ArrayLookup(a,b);}
          break;
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
   {if (true) return(a);}
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp14() throws ParseException {
 Exp a,b;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BANG:
      jj_consume_token(BANG);
      a = Exp16();
                        {if (true) return new Not(a);}
      break;
    case TRUE:
    case FALSE:
    case THIS:
    case NEW:
    case LPAREN:
    case NUMBER:
    case ID:
      a = Exp16();
                 {if (true) return a;}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp16() throws ParseException {
 Exp a;
 Token t;
 Identifier i;
 ExpList c;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      t = jj_consume_token(NUMBER);
              {if (true) return new IntegerLiteral(Integer.parseInt(t.image));}
      break;
    case TRUE:
      jj_consume_token(TRUE);
          {if (true) return new True();}
      break;
    case FALSE:
      jj_consume_token(FALSE);
            {if (true) return new False();}
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      a = Exp();
      jj_consume_token(RPAREN);
   {if (true) return(new ExpGroup(a));}
      break;
    case ID:
      i = Identifier();
                     {if (true) return new IdentifierExp(i.s);}
      break;
    case THIS:
      jj_consume_token(THIS);
          {if (true) return new This();}
      break;
    default:
      jj_la1[12] = jj_gen;
      if (jj_2_11(3)) {
        jj_consume_token(NEW);
        jj_consume_token(INT);
        jj_consume_token(LBRACKET);
        a = Exp();
        jj_consume_token(RBRACKET);
   {if (true) return new NewArray(a);}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NEW:
          jj_consume_token(NEW);
          i = Identifier();
          jj_consume_token(LPAREN);
          jj_consume_token(RPAREN);
   {if (true) return new NewObject(i);}
          break;
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public Identifier Identifier() throws ParseException {
  Token t;
    t = jj_consume_token(ID);
            {if (true) return new Identifier(t.image);}
    throw new Error("Missing return statement in function");
  }

  static final public ExpList ExpList() throws ParseException {
 ExpList a;
 Exp b;
    b = Exp();
           a = new ExpList(null,b);
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_11;
      }
      jj_consume_token(COMMA);
      b = Exp();
                    a=new ExpList(a,b);
    }
   {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  static private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  static private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  static private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  static private boolean jj_2_11(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  static private boolean jj_3R_15() {
    if (jj_scan_token(PLUS_OP)) return true;
    if (jj_3R_21()) return true;
    return false;
  }

  static private boolean jj_3R_22() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_25()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) return true;
    }
    return false;
  }

  static private boolean jj_3R_24() {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3_8() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) return true;
    }
    return false;
  }

  static private boolean jj_3R_19() {
    if (jj_scan_token(CLASS)) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_23() {
    if (jj_scan_token(INT)) return true;
    return false;
  }

  static private boolean jj_3R_14() {
    if (jj_3R_21()) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_scan_token(CLASS)) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_19()) return true;
    }
    return false;
  }

  static private boolean jj_3_5() {
    if (jj_scan_token(INT)) return true;
    if (jj_scan_token(LBRACKET)) return true;
    return false;
  }

  static private boolean jj_3R_34() {
    if (jj_scan_token(NEW)) return true;
    return false;
  }

  static private boolean jj_3_7() {
    if (jj_scan_token(LT)) return true;
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3R_20() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_4()) {
    jj_scanpos = xsp;
    if (jj_3_5()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) {
    jj_scanpos = xsp;
    if (jj_3R_24()) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3_4() {
    if (jj_scan_token(BOOLEAN)) return true;
    return false;
  }

  static private boolean jj_3_10() {
    if (jj_scan_token(DOT)) return true;
    if (jj_3R_18()) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  static private boolean jj_3_11() {
    if (jj_scan_token(NEW)) return true;
    if (jj_scan_token(INT)) return true;
    if (jj_scan_token(LBRACKET)) return true;
    return false;
  }

  static private boolean jj_3R_33() {
    if (jj_scan_token(THIS)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3R_32() {
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_31() {
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    if (jj_3R_20()) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_3R_22()) return true;
    return false;
  }

  static private boolean jj_3R_30() {
    if (jj_scan_token(FALSE)) return true;
    return false;
  }

  static private boolean jj_3R_29() {
    if (jj_scan_token(TRUE)) return true;
    return false;
  }

  static private boolean jj_3R_28() {
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  static private boolean jj_3R_27() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) {
    jj_scanpos = xsp;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) {
    jj_scanpos = xsp;
    if (jj_3R_33()) {
    jj_scanpos = xsp;
    if (jj_3_11()) {
    jj_scanpos = xsp;
    if (jj_3R_34()) return true;
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3_9() {
    if (jj_scan_token(TIMES_OP)) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3R_21() {
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3R_26() {
    if (jj_3R_27()) return true;
    return false;
  }

  static private boolean jj_3_6() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(EQUALS)) return true;
    return false;
  }

  static private boolean jj_3R_25() {
    if (jj_scan_token(BANG)) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_scan_token(MINUS_OP)) return true;
    if (jj_3R_21()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public PA4TokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  /** Whether we are looking ahead. */
  static private boolean jj_lookingAhead = false;
  static private boolean jj_semLA;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80,0x2000,0x20,0x8000000,0x1a0000,0x120000,0x80000,0x40000000,0x0,0x10000000,0x10000000,0x1c18000,0x418000,0x800000,0x8000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x800,0x0,0x0,0x820,0x20,0x800,0x0,0x180,0x8,0x8,0xc02,0xc02,0x0,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[11];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public PA4(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public PA4(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new PA4TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public PA4(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new PA4TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public PA4(PA4TokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(PA4TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[44];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 44; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 11; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
