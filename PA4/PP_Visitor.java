import syntaxtree.*;

/* 
 * this class uses the Visitor pattern 
 * to pretty print the miniC program
 * The idea is to have each node return its string representation!
*/

 public class PP_Visitor implements Visitor
 {


   private String indentString(int indent) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4*indent; ++i) {
        sb.append(' ');
        }
        return sb.toString();
   }
     public Object visit(MainClass node, Object data){
         int indent = (int) data;
         String i = (String) node.i.accept(this, indent);
         String s = (String) node.s.accept(this, indent);

         return "class " + i + "{\n" + indentString(indent+1) + "public static void main(String[] args){"+ "\n\n" + indentString(indent+2) + s + indentString(indent+1) + "}" + "\n}\n";

     }
   public Object visit(Program node, Object data){

       int indent = (int) data;
       String m = (String) node.m.accept(this, indent);
       String c = "";
       if (node.c!=null){
           c = (String) node.c.accept(this,data);
       }
       return m + "\n" + c;
   }
    //edited by me
   //edited by me
   public Object visit(ClassDecl node, Object data){
       int indent = (int)data;
       String i = (String)node.i.accept(this, indent);
       String v = (String)node.v.accept(this, indent+1);
       String m = (String)node.m.accept(this, indent+1);
       return "class " + i + "{\n" + v + m + "}";
   }
   public Object visit(VarDecl node, Object data){
        int indent = (int) data; 
        String t = (String) node.t.accept(this,indent);
        String i = (String) node.i.accept(this,indent);
        return indentString(indent)+t + " "+i +";\n";
   }
   public Object visit(MethodDecl node, Object data){
        // 
        int indent = (int) data; 
        String type = (String) node.t.accept(this,indent);
        String id = (String) node.i.accept(this,indent);
        String formalList = "";
        if (node.f!=null){
            formalList = (String) node.f.accept(this,indent);
        }
        String varList = "";
        if (node.v!=null){
            varList = (String) node.v.accept(this,indent+1);
        }
        String statementList = "";
        if (node.s!=null){
            statementList = (String) node.s.accept(this,indent+1);
        }
        String expr = (String) node.e.accept(this,indent);
        return 
        indentString(indent)+ "public " + type+" "+id+"("+formalList+"){\n"+
        varList +
        statementList+
        indentString(indent+1)+"return "+expr +";\n"+
        indentString(indent)+"}\n";
   }
   public Object visit(Formal node, Object data){
        // 
        int indent = (int) data; 
        String type = (String) node.t.accept(this,indent);
        String id = (String) node.i.accept(this,indent);
        return type+" "+id;
   }

   public Object visit(IntArrayType node, Object data){
       int indent = (int) data;

     return "int []";
   }
   public Object visit(IntegerType node, Object data){
        // 
        int indent = (int) data; 
        return "int";
   }
   public Object visit(BooleanType node, Object data){
        // 
        int indent = (int) data; 
        return "boolean";
   }
   public Object visit(IdentifierType node, Object data){
       int indent = (int) data;
       String s = (String) node.s;
     return s;
   }
   public Object visit(Block node, Object data){
        // 
        int indent = (int) data; 
        String result="";
        if (node.slist!=null){
            result = (String) node.slist.accept(this,indent);
        }

        return "{\n"+ result + indentString(indent-1) + "}\n";
   }
   public Object visit(If node, Object data) {
       //
       int indent = (int) data;
       String expr = (String) node.e.accept(this, indent+1);
       String s1 = (String) node.s1.accept(this, indent+1);
       if (node.s2 != null) {
           String s2 = (String) node.s2.accept(this, indent+1);
           return indentString(indent) + "if (test" + expr + ")" + s1 + indentString(indent) + "else" + s2;
       } else {
           return indentString(indent) + "if (" + expr + ")" + s1;
       }
   }
   public Object visit(While node, Object data){
        int indent = (int) data;
        String expr = (String)node.e.accept(this,indent);
        String s = (String)node.s.accept(this,indent+1);
        return indentString(indent) + "while(" + expr + ")" + s +"\n";
   }
   public Object visit(Print node, Object data){
        // 
        int indent = (int) data; 
        String e = (String) node.e.accept(this,indent);
        //--indent;
        return indentString(indent) + "System.out.println("+e+");\n";
   }
   public Object visit(Assign node, Object data){
        // 
        int indent = (int) data; 
        String i = (String) node.i.accept(this,indent);
        String e = (String) node.e.accept(this,indent);
        //--indent;
        return indentString(indent)+i+" = "+e+";\n";
   }

   
   public Object visit(ArrayAssign node, Object data){
       int indent = (int) data;
     Identifier i = node.i;
     Exp e1 = node.e1;
     Exp e2 = node.e2;
     String id = (String) i.accept(this,0);
     String exp1 = (String) e1.accept(this,0);
     String exp2 = (String) e2.accept(this,0);
     data = indentString(indent)+id+"["+exp1+"] = "+exp2+";\n";
     return data; 
   } 

    //edited by me
   public Object visit(And node, Object data){
       int indent = (int) data;
       String e1 = (String) node.e1.accept(this,indent);
       String e2 = (String) node.e2.accept(this,indent);
       return e1+" && "+e2;
   }

   public Object visit(LessThan node, Object data){
        // 
        int indent = (int) data; 
        String e1 = (String) node.e1.accept(this,indent);
        String e2 = (String) node.e2.accept(this,indent);
        return e1+"<"+e2;
   }
   public Object visit(Plus node, Object data){
        // 
        int indent = (int) data; 
        String e1 = (String) node.e1.accept(this,indent);
        String e2 = (String) node.e2.accept(this,indent);
        return e1+" + "+e2;
   }
   public Object visit(Minus node, Object data){
        // 
        int indent = (int) data; 
        String e1 = (String) node.e1.accept(this,indent);
        String e2 = (String) node.e2.accept(this,indent);
        return e1+" - "+e2;
   }
   //edited by me
   public Object visit(Times node, Object data){
        // 
        int indent = (int) data; 
        String e1 = (String) node.e1.accept(this,indent);
        String e2 = (String) node.e2.accept(this,indent);
        return e1+" * "+e2;
   }
   //edited by me
   public Object visit(ArrayLookup node, Object data){
       int indent = (int) data;
       String a = (String) node.e1.accept(this, indent);
       String b = (String) node.e2.accept(this, indent);

     return a + "[" + b + "]";
   }
  //edited by me
   public Object visit(ArrayLength node, Object data){
       int indent = (int) data;
       String a = (String) node.e.accept(this, indent);
       return a + ".length";
   }
   public Object visit(Call node, Object data){
        // 
        int indent = (int) data; 
        String e1 = (String) node.e1.accept(this,indent);
        String i = (String) node.i.accept(this,indent);
        String e2 = (String) node.e2.accept(this,indent);

        return e1 + "." + i+"("+e2+")";
   }
   public Object visit(IntegerLiteral node, Object data){
        int indent = (int) data; 
        int i = node.i;
        return ""+i+"";
   }
   public Object visit(True node, Object data){
        // 
        int indent = (int) data; 
        //--indent;
        return "true";
   }
   public Object visit(False node, Object data){
        // 
        int indent = (int) data; 
        //--indent;
        return "false";
   }
   public Object visit(IdentifierExp node, Object data){

        int indent = (int) data; 
        String s = node.s;
        //--indent;
        return s;
   }
   //edited by me
     public Object visit(This node, Object data){
     return "this";
   }
   //edited by me
   public Object visit(NewArray node, Object data){

       int indent = (int)data;
       String e = (String)node.e.accept(this, indent);
       return "new int[" + e + "]";
   }
  //edited by me
   public Object visit(NewObject node, Object data){

       int indent = (int)data;
       String i = (String)node.i.accept(this, indent);
       return "new " + i + "()";
   }
//edited by me
   public Object visit(Not node, Object data){

       int indent = (int)data;

       String e = (String) node.e.accept(this, indent);
       return "!" + e;
   }
   public Object visit(Identifier node, Object data){

        int indent = (int) data; 
        String s = node.s;
        //--indent;
        return s;
   }

   public Object visit(ExpGroup node, Object data){
     String e="";
     if (node.e!=null){
         e = (String) node.e.accept(this,data);
     }
     return "("+e+")";
   }
//edited by me
   public Object visit(ClassDeclList node, Object data){
      int indent = (int)data;
     String c = (String)node.c.accept(this, indent);
     String clist = "";
     if(node.clist != null){
         clist = (String)node.clist.accept(this, indent);
         return c + ", " + clist;
     } else{
         return c;
     }
   }

public Object visit(ExpList node, Object data){
        // 
        int indent = (int) data; 
        String e = (String) node.e.accept(this,indent);
        if (node.elist!=null){
            String e1 = (String) node.elist.accept(this,indent);
            e = e1 + ", "+e;
        }

        return e;
   }
   public Object visit(FormalList node, Object data){
        // 
        int indent = (int) data; 
        String f = (String) node.f.accept(this,indent);
        if (node.flist!=null){
            String f1 = (String) node.flist.accept(this,indent);
            f = f1 +", "+f;
        }
        //--indent;
        return f;
   }
   public Object visit(MethodDeclList node, Object data){
        // 
        int indent = (int) data; 
        String m = (String) node.m.accept(this,indent);
        if (node.mlist!=null){
            String m2 = (String) node.mlist.accept(this,indent);
            m = m2 +"\n"+m; 
        }
        return m;
   }
   public Object visit(StatementList node, Object data){
        // 
        int indent = (int) data; 
        String result="";
        
        if (node.slist!=null){
            String s = (String) node.slist.accept(this,indent);
            result = result+s;
        }
        String t = (String) node.s.accept(this,indent);
        //--indent;
        result = result+t;
        return result;
   }


   public Object visit(VarDeclList node, Object data){
        // 
        int indent = (int) data; 
        String v = (String) node.v.accept(this,indent);
        
        if (node.vlist!=null){
            String vlist = (String) node.vlist.accept(this,indent);
            v = vlist + v;
        }
        
        return v;
   }
}

 

 