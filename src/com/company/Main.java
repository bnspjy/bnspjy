package com.company;
import java.util.*;

public class Main {
    public static class UserScore {
        String name;
        Integer kor;
        Integer eng;
        Integer sum;
        Integer rank;

        public UserScore(String name, int kor, int eng) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            sum = kor + eng;
            rank = 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<UserScore> scores = new ArrayList<>();
        String[] names = {"홍길동", "강호동", "유재석", "박명수"};
        int[] kors = {60, 70, 80, 90};
        int[] engs = {75, 80, 55, 100};

        //Input
        for (int n=0; n<names.length; n++) {
            UserScore score = new UserScore(names[n], kors[n], engs[n]);
            scores.add(score);
        }

        //Rank by sum
        for (int n=0; n<names.length; n++) {
            UserScore compA = scores.get(n);

            for (int m=0; m<names.length; m++) {
                UserScore compB = scores.get(m);

                if (compA.sum < compB.sum) {
                    compA.rank++;
                }
            }
        }

        //Sort by name
        scores.sort(new Comparator<UserScore>() {
            @Override
            public int compare(UserScore o1, UserScore o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        //Output
        for (int n=0; n<names.length; n++) {
            UserScore score = scores.get(n);
            System.out.printf("이름: %s, 총점: %d, 순위: %d\n", score.name, score.sum, score.rank);
        }
    }
}


/*
    public static void method3() {
        int num=10;
        boolean result=false && ++num>0;
        System.out.println("result확인:"+result);
        System.out.println("num="+num);

        boolean result2=true || ++num>0;
        System.out.println("result확인:"+result2);
        System.out.println("num="+num);

    }

    public static void method4() {
        int a=2;
        int b=3;

        boolean c=a>b;// false
        boolean d=++a <= b++;// true

        System.out.println("a:"+a); //3
        System.out.println("b:"+b); //4
        System.out.println("c:"+c);
        System.out.println("d:"+d);
        System.out.println();
        System.out.println("!c:"+!c);
        System.out.println("c !=d:"+(c!=d));
        System.out.println("(a%b)==1:"+((a%b)==1));
    }

    public static void method5() {
        while (true) {
            System.out.println("1~9사이의 양수를 입력해야 합니다.");

            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            if (0 < num && 10 > num)
            {
                System.out.println("입력된 수 :" + num);

                for (int n=1; n<10; n++)
                    System.out.println(num + " * " + n + " = " + n * num);
            }
        }
    }

    public static void method2() {
        for (int dan = 2; dan < 10; dan++) {
            System.out.println("=======" + dan + "단=======");
            for (int su = 1; su < 10; su++) {
                if (dan % 2 == 0 || su % 2 == 0) {
                    continue;
                }
                System.out.println(dan + "*" + su + "=" + (dan * su));
            }
            System.out.println();
        }
    }

    public static void practice8() {
        Scanner sc=new Scanner(System.in);

        System.out.print("피연산자1 입력:");
        //int num1=sc.nextInt();
        double num1 = sc.nextDouble();

        System.out.print("피연산자2 입력:");
        //int num2=sc.nextInt();
        double num2 = sc.nextDouble();

        System.out.print("연산자를 입력(+,-,*,/,%) :");
        char ch=sc.next().charAt(0);

        double result=0;
        int result1=0;

        if(num1>0 && num2>0) {
            switch(ch){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result= num1/num2;
                    break;
                case '%':
                    result=num1%num2;
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
            }

            System.out.printf("%f %c %f = %d\n",num1,ch,num2,result1);
            System.out.printf("%f %c %f = %.6f\n",num1,ch,num2,result);
        }
        else {
            System.out.println("양수만을 입력해 주세요. 프로그램을 종료합니다.");
        }
    }
    public static void practice5() {
        Scanner sc=new Scanner(System.in);

        System.out.print("문자열:");
        String str=sc.nextLine();
        System.out.print("문자:");
        char ch=sc.nextLine().charAt(0);

        char[] chArr = str.toCharArray();
        int count=0;

        for(int i=0;i<chArr.length;i++) {
            //str.
            if(chArr[i] == ch) {
                count=i+1;
            }
        }

        System.out.print(str+"에"+ch+"가 존재하는 위치(인덱스):"+count);


    }

    public static void practice6() {

        for(int i=0;i<=10;i++){
            for(int j=0; j<=5;j++){
                if(i==2){
                    System.out.print("c");
                }
                else {
                    if (j == 2) {
                        System.out.print("a");
                    } else
                        System.out.print("*");
                }
            }

            System.out.println(" ");
        }
    }
    public static void practice7() {
        Scanner sc=new Scanner(System.in);
        //다섯개의 배열에 숫자를 넣어-> 평균
        int[] ma = new int[5];
        int sum=0;
        int idx=0;
        double avg;


        while(true){
            System.out.print("양수를 입력하세요:");
            int num=sc.nextInt();
            ma[idx++] = num;
            if (idx==5){
                idx=4;
            for(int j=0;j<ma.length-1;j++){
                ma[j]=ma[j+1];
            }
            sum=0;
            for(int i=0;i<ma.length;i++) {
                sum += ma[i];
            }

            avg = (double) sum / ma.length;
            System.out.print("평균"+avg);
            }



        }
        }

    public static void practice10() {
        String[] arr = {"후라이드", "양념", "파닭", "매콤", "치즈", "간장"};

        Scanner sc = new Scanner(System.in);
        System.out.print("치킨 이름을 입력하세요:");
        String chicken = sc.nextLine();
        boolean isExist = false;

        for(int n=0; n<arr.length; n++) {
            if (chicken.equals(arr[n])) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            System.out.println(chicken + "치킨 배달 가능");
        }
        else {
            System.out.println(chicken + "치킨은 없는 메뉴입니다.");
        }
    }

    public static void practice13() {
        Scanner s=new Scanner(System.in);
        int[] aa=new int[5];
        int max=0;

        for(int i=0;i<aa.length;i++) {
            aa[i]=s.nextInt();

            if(max<aa[i]) {
                max=aa[i];
            }
        }
        System.out.println("입력된 수에서 가장 큰 수는"+max+"입니다.");

        // 문자열 : application
        // 문자열에 있는 문자 : a,p,l,i,c,t,o,n
        // 문자 개수 : 8

        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        int sum = a + b + c + d;
        System.out.println(sum);

        final int cnt = 4;
        int[] array = new int[4];
        //Scanner s = new Scanner(System.in);

        for(int n=0; n<array.length; n++)
        {
            System.out.print((n + 1) + "번째 숫자를 입력하세요:");
            array[n]=s.nextInt();
        }

        Scanner sc=new Scanner(System.in);
        System.out.print("문자열:");
        String str=sc.nextLine(); //application

        char[] chArr=new char[str.length()+1]; //'\u0000' null default
        chArr[0]=str.charAt(0);//a

        boolean check=false;
        for(int i=1;i<str.length();i++) {
            for(int j=0;j<chArr.length;j++) {
                if(str.charAt(i) == chArr[j]) {
                    check=true;
                    break;
                }
            }

            if(!check) {
                for(int k=1;k<chArr.length;k++) {
                    if(chArr[k] == '\u0000') {
                        chArr[k]=str.charAt(i);
                        break;
                    }
                }
            }
            check=false;
        }
        int count=0;
        System.out.print("문자열에 있는 문자:");
        for(int i=0;i<chArr.length;i++) {
            if(chArr[i] !='\u0000') {
                if(chArr[i+1]=='\u0000') {
                    System.out.print(chArr[i]);
                    System.out.println();
                }else {
                    System.out.print(chArr[i]+",");
                }
                count++;
            }

        }
        System.out.println("문자 개수:"+count);
    }

    public static void test() {
        Scanner s = new Scanner(System.in);
        System.out.print("배열의 크기를 입력하세여 : ");
        int size = s.nextInt();
        boolean isRun = true;
        String[] array = null;
        s.nextLine();

        while (isRun)
        {
            if (size > 0) {
                String[] bufs = new String[size];

                for(int n=0; n<bufs.length; n++) {
                    System.out.print((n + 1) + "번째 문자열 : ");
                    bufs[n] = s.nextLine();
                }

                if (array != null && array.length > 0) {
                    String[] temp = new String[array.length];

                    for(int n=0; n<temp.length; n++) { //Copy Array -> Temp
                        temp[n] = array[n];
                    }

                    array = new String[temp.length + bufs.length];
                    int idx = 0;

                    for(int n=0; n<temp.length; n++) { //Copy Temp -> Array
                        array[idx++] = temp[n];
                    }

                    for(int n=0; n<bufs.length; n++) { //Copy Buf -> Array
                        array[idx++] = bufs[n];
                    }
                }
                else {
                    array = new String[bufs.length];

                    for(int n=0; n<bufs.length; n++) { //Copy
                        array[n] = bufs[n];
                    }
                }


                System.out.print("값을 더 입력하시겠습니까?(Y/N) : ");
                String end = s.nextLine();

                if (end.equals("y") || end.equals(("Y"))) {
                    System.out.print("더 입력하고 싶은 개수 : ");
                    size = s.nextInt();
                    s.nextLine();
                }
                else {
                    isRun = false;
                }
            }
        }
        System.out.print("[");
        for(int n=0; n<array.length; n++)
            System.out.print(array[n] + ",");
        System.out.print("]");
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 크기를 입력하세요:");
        int num = sc.nextInt();
        String[] strArr = new String[num];
        sc.nextLine();
        boolean check = false;

        for (int i = 0; i < strArr.length; i++) {
            System.out.print((i + 1) + "번째 문자열:");
            strArr[i] = sc.nextLine();
        }

        while (!check) {
            System.out.print("더 값을 입력하시겠습니까?(Y/N):");
            char aa = sc.nextLine().charAt(0);


            if (aa == 'y' || aa == 'Y') {
                System.out.print("더 입력하고 싶은 개수:");
                int add = sc.nextInt();
                String[] newstrArr = new String[num + add];

                sc.nextLine();

                for (int j = 0; j < strArr.length; j++) {
                    newstrArr[j] = strArr[j];
                }
                for (int k = num; k < newstrArr.length; k++) {
                    System.out.print((k + 1) + "번째 문자열:");
                    newstrArr[k] = sc.nextLine();
                }
                num = num + add;

            } else if (aa == 'n' || aa == 'N') {
                for (int m = 0; m < strArr.length; m++)
                    System.out.println(strArr[m] + ",");
            }
        }
    }
    public static void test1() {
        Scanner sc=new Scanner(System.in);
        System.out.print("배열의 크기를 입력하세요:");
        String[] strArr=new String[sc.nextInt()];
        sc.nextLine();

        for(int i=0;i<strArr.length;i++) {
            System.out.print((i+1)+"번째 문자열:");
            strArr[i]=sc.nextLine();
        }

        System.out.print("더 값을 입력하시겠습니까?(Y/N)");
        char aa=sc.nextLine().charAt(0);

        if(aa=='y' || aa=='Y') {
            System.out.print("더 입력하고 싶은 개수:");
            int add=sc.nextInt();
            int idx = 0;
            String[] newStrArr = new String[add];
            String[] tempArr = new String[strArr.length];
            sc.nextLine();

            for(int i=0;i<newStrArr.length;i++) {
                System.out.print((i+1)+"번째 문자열:");
                newStrArr[i]=sc.nextLine();
            }

            for (int n=0; n<tempArr.length; n++)
                tempArr[n] = strArr[n];

            strArr = new String[tempArr.length + newStrArr.length];

            for (int n=0; n<tempArr.length; n++)
                strArr[idx++] = tempArr[n];

            for (int n=0; n<newStrArr.length; n++)
                strArr[idx++] = newStrArr[n];

            System.out.print("["); //종료 프린트
            for(int n=0; n<strArr.length; n++)
                System.out.print(strArr[n] + ",");
            System.out.print("]");
        }else if(aa=='n' || aa=='N') {

            System.out.print("["); //종료 프린트
            for(int n=0; n<strArr.length; n++)
                System.out.print(strArr[n] + ",");
            System.out.print("]");
        }
    }

    public static void test3() {
        Scanner sc=new Scanner(System.in);
        System.out.print("배열의 크기를 입력하세요:");
        int num=sc.nextInt();
        String[] strArr=new String[num];
        sc.nextLine();
        boolean check = false;

        for(int i=0;i<strArr.length;i++) {
            System.out.print((i+1)+"번째 문자열:");
            strArr[i]=sc.nextLine();
        }

        while(!check) {
            System.out.print("더 값을 입력하시겠습니까?(Y/N):");
            char aa=sc.nextLine().charAt(0);

            if(aa=='y' || aa=='Y') {
                System.out.print("더 입력하고 싶은 개수:");
                int add=sc.nextInt();
                String[] newstrArr=new String[num+add];//밖에서 선언해야 함.
                sc.nextLine();

                for(int j=0;j<strArr.length;j++) {
                    newstrArr[j]=strArr[j];
                }

                for(int k=num; k<newstrArr.length;k++) {
                    System.out.print((k+1)+"번째 문자열:");
                    newstrArr[k]=sc.nextLine();
                }
                num=num+add;
                strArr = new String[newstrArr.length];

                for(int j=0;j<strArr.length;j++) {
                    strArr[j]=newstrArr[j];
                }
            }else if(aa=='n' || aa=='N') {
                check=true;
            }
        }

        System.out.print("["); //종료 프린트
        for(int m=0;m<strArr.length;m++)
            if(m==strArr.length-1) {
                System.out.print(strArr[m]);
            }else {
                System.out.print(strArr[m]+",");
            }
        System.out.print("]");
    }

    public static void test4() {
        int[][] arr=new int[4][4];
        int sum=0;

        for(int i=0; i<arr.length-1; i++) { //-1 해주는 이유: 한칸씩은 합이 들어가야 하기 때문에
            for(int j=0; j<arr[i].length-1; j++) {
                arr[i][j]=(int)(Math.random()*10)+1;
                arr[i][j]=1;
            }
        }

        for(int i=0; i<arr.length-1; i++) { //-1 해주는 이유: 한칸씩은 합이 들어가야 하기 때문에
            for(int j=0; j<arr[i].length-1; j++) {
                arr[i][3] += arr[i][j];
                arr[3][j] += arr[i][j];

                if (i == 2)
                    arr[3][3] += arr[3][j];
            }

            arr[3][3] += arr[i][3];
        }

        for(int i=0; i<arr.length; i++) { //-1 해주는 이유: 한칸씩은 합이 들어가야 하기 때문에
            for(int j=0; j<arr[i].length; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void practice9() {
        String[][] arr = new String[6][6];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = " ";
            }
        }

        arr[1][1] = "X";

        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                arr[i][0] = Integer.toString(i - 1);
            for (int j = 0; j < arr[i].length; j++) {
                if (j > 0)
                    arr[0][j] = Integer.toString(j - 1);

                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        String[] student = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
        String[][] seat1 = new String[3][2];
        String[][] seat2 = new String[3][2];
        int count = 0;

        System.out.println("==1분단==");
        for (int i = 0; i < seat1.length; i++) {
            for (int j = 0; j < seat1[i].length; j++) {
                seat1[i][j] = student[count];
                count += 1;
                System.out.print(seat1[i][j] + " ");
            }
            System.out.println();

        }

        System.out.println("==2분단==");
        for (int i = 0; i < seat2.length; i++) {
            for (int j = 0; j < seat2[i].length; j++) {
                seat2[i][j] = student[count];
                count += 1;
                System.out.print(seat2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("===============================");
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 학생 이름을 입력하세요 : ");
        String name = sc.nextLine();
        String partName = ""; //분단
        String colName = "";  //왼, 오른
        int rowName = 0;  //줄

        //System.out.printf("검색하신 %s 학생은 %s분단 %s줄 %s쪽에 있습니다.", name,partName,colName,rowName);

        for (int i = 0; i < seat1.length; i++) {
            for (int j = 0; j < seat1[i].length; j++) {
                if (name.equals(seat1[i][j])) {
                    partName = "1분단";
                    if (j == 0)
                        colName = "왼";
                    else
                        colName = "오른";
                    rowName = i + 1;
                    System.out.printf("검색하신 %s학생은 %s %d번째줄 %s쪽에 있습니다.\n", name, partName, rowName, colName);
                } else
                    break;
            }
        }

        for (int i = 0; i < seat2.length; i++) {
            for (int j = 0; j < seat2[i].length; j++) {
                if (seat2[i][j].equals(name)) {
                    partName = "2분단";
                    if (j == 0)
                        colName = "왼";
                    else
                        colName = "오른";
                    rowName = i + 1;
                    System.out.printf("검색하신 %s학생은 %s %d번째줄 %s쪽에 있습니다.", name, partName, rowName, colName);
                } else
                    break;
            }
        }
    }

    public interface A extends B, C {

    }

    public interface  B {

    }
    public interface  C {

    }

* */