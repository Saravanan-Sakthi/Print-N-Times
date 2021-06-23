package string.printntimes;
import java.util.Scanner;
class PrintNTimes{
  int z;
  int ascii(char a){
    return (int)a;
  }
  char[] capitalize(char[] A, int i){
    int n= ascii(A[i+3])-48;
    String a= "";
    String b="";
    for (;A[i-1]!='(';i--){
      if (ascii(A[i-1])>90)a=(char)(ascii(A[i-1])-32)+a;
      else a=A[i-1]+a;
    }
    while(n-->=1) b= b+a;
    //System.out.println(b);
    return b.toCharArray();
  }
  char[] decapitalize(char[] A, int i){
    int n= ascii(A[i+2])-48;
    String a= "";
    String b="";
    for (;A[i-1]!='(';i--){
      if (ascii(A[i-1])>90)a=A[i-1]+a;
      else a=(char)(ascii(A[i-1])+32)+a;
    }
    while(n-->=1) b= b+a;
    //System.out.println(b);
    return b.toCharArray();
  }
  String route(char [] A, int i){
    char[]B;
    String a;
    if (A[i+2]=='-'){
    //  System.out.println("Capital");
      B=capitalize(A,i);
      a= makeString(A,B,'c',i);
    }
    else {
    //  System.out.println("small");
      B=decapitalize(A,i);
      a= makeString(A,B,'d',i);
    }
    z=0;
    return a;
  }
  String makeString(char[]A, char[]B,char c,int j){
    String a="";
    /*for (int i=0;i<A.length;i++) System.out.print(A[i]);
    System.out.println();
    for (int i=0;i<B.length;i++) System.out.print(B[i]);
    System.out.println();
    System.out.println(j);*/
    for (int i=0;i<B.length;i++)a=a+B[i];
    //System.out.println(a);
    for (int k=(c=='c')? j+5:j+4;k<A.length;k++) {
      //System.out.println(k);
      a=a+A[k];
    }
    for (;A[j]!='(';j--);//System.out.println(j);
    //System.out.println(j);
    for (j=j-1;j>=0;j--) a=A[j]+a;
    //System.out.println(a);
    return a;
  }
  String clearbrace(char[]A, int j){
    int i=j;
    String a="";
    for (;A[i]!='(';i--);
    //System.out.println(j);
    for (int k=0;k<A.length;k++) {
      if (k==i||k==j) continue;
      a=a+A[k];
    }
    //System.out.println(a);
    z=0;
    return a;
  }
  void check(String A){
    while(true){
      if ((int)A.charAt(0)>=65){
        System.out.println(A);
        break;
      }
      else {
        for (z=0;z<A.length()-1;z++){
          //System.out.println("return");
          if (A.charAt(z)==')'&& A.charAt(z+1)=='{') A=route(A.toCharArray(),z);
          else if (A.charAt(z)==')'&& A.charAt(z+1)!='{') A=clearbrace(A.toCharArray(),z);
          //i=0;
        }
      }
    }
  }
}
