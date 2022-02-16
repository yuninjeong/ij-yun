# Chapter 2 변수

- 2-1
    
    ![Untitled](Chapter%202%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%201e935e3e4e54499eb3fa31957598721d/Untitled.png)
    
- 2-2
    
    주민등록번호를 숫자로 저장하고자 한다 이 값을 저장하기 위해서는 어떤 자료형
    (data type) 을 선택해야 할까? regNo라는 이름의 변수를 선언하고 자신의 주민등록번호로
    초기화 하는 한 줄의 코드를 적으시오.
    
    long regNo = 9109182222535L;
    
    주민등록번호는 정수이다. 정수 타입으로는 보통 int형을 사용하지만 주민등록번호는 13자리로 int(4byte)형의 범위를 넘어선다. 그렇기 때문에 long형을 사용해야 하는 것이고, 리터럴 접미사 L을 붙여준다.
    
- 2-3
    
    다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오
    
    int i = 100;
    
    long l = 100L;
    
    final float PI = 3.14f;
    
    리터럴: 100, 100L, 3.14f
    
    변수: i, l
    
    상수: PI
    
    키워드: int, long, final, float
    
    변수: 단 하나의 값을 저장하는 “메모리 공간”, 새로운 값을 저장하게 되면 이전의 값은 사라진다.
    
    상수: 값을 딱 한 번만 저장할 수 있는 “메모리 공간” 
    
        리터럴에 의미있는 이름을 붙여 코딩을 쉽게 하는 역할 
    
    리터럴: 값 자체. 상수의 다른 이름이지만 프로그래밍에서의 상수는 메모리 공간을 뜻한다.
    
    키워드: 예약어(또는 reserved word) 프로그래밍언어의 구문에 사용되는 단어
    
- 2-4
    
    다음 중 기본형 이 아닌 것은 (primitive type) ?
    
    a. int
    
    b. Byte
    
    c. double
    
    d. boolean
    
    b. Byte !! byte와 Byte는 다른 것이다.
    
    기본형: boolean, byte, short, char, int, long, float, double 모두 8개
    
    그 외의 타입은 모두 참조형 이다 (reference type) .
    
- 2-5
    
    다음 문장들의 출력결과를 적으세요. 오류가 있는 문장인 경우 오류라고 적으세요.
    
    System.out.println(“1” + “2”) ( 12 )
    
    System.out.println(true + “”) ( true)
    
    System.out.println(‘A' + 'B') ( AB → 131 (65+66))
    
    System.out.println('1' + 2) ( 12 → 51 (49+2))
    
    System.out.println('1' + '2') ( 12 → 99 (49+50))
    
    System.out.println('J' + “ava”) ( Java )
    
    System.out.println(true + null) ( ? → 오류 )
    
    문자열: “” 
    
    문자: ‘’
    
    문자열과 덧셈연산을 하면 항상 결과값도 문자열이 된다.
    
    문자와 문자의 덧셈연산의 결과값은 int형이다.
    
    int형보다 작은 타입(byte, short, char)은 int형으로 변환된 후에 덧셈연산이 진행된다.
    
    A 문자코드: 65
    
    1 문자코드: 49 
    
- 2-6
    
    다음 중 키워드가 아닌 것은 모두 고르시오 ?
    
    a. if
    
    b. True
    
    c. NULL
    
    d. Class
    
    e. System
    
    b, c, d, e 4가지
    
    키워드는 소문자로만 이루어져있다.
    
    class, true, null 은 키워드이다.
    
- 2-7
    
    다음 중 변수의 이름으로 사용할 수 있는 것은 모두 고르시오 ? 
    
    a. $ystem
    
    b. channel#5
    
    c. 7eleven
    
    d. If
    
    e. 자바
    
    f. new
    
    g. $MAX_NUM
    
    h. hello@com
    
    e,f → a,d,e,g
    
    b,h 는 허용되지 않는 특수문자가 있어 사용 불가
    
    c는 숫자로 시작해서 사용 불가
    
    f는 new가 예약어이기 때문에 사용 불가
    
    변수의 규칙
    
    1. 대소문자 구분
    2. 예약어 사용 금지
    3. 숫자로 시작 금지
    4. 특수문자는 ‘_’ 와 ‘&’만 허용
- 2-8
    
    참조형 변수(reference type) 와 같은 크기의 기본형(primitive type)은 모두 고르시오
    
    a. int
    
    b. long
    
    c. short
    
    d. float
    
    e. double
    
    a, d
    
    long: 8byte / short: 2byte / double:8byte
    
    모든 참조형 변수는 크기가 4 byte
    
- 2-9
    
    다음 중 형변환을 생략할 수 있는 것은 모두 고르시오 ? 
    
    byte b = 10;
    char ch = 'A';
    int i = 100;
    long l = 1000L;
    
    a. b = (byte)i;
    b. ch = (char)b;
    c. short s = (short)ch;
    d. float f = (float)l;
    e. i = (int)ch;
    
    a. b = (byte)i; // int(4byte) byte(1byte) → 이므로 반드시 형변환 필요
    b. ch = (char)b; // byte(1byte) char(2byte) → 이지만 범위가 달라서 형변환 필요
    c. short s = (short)ch; // char,short 2byte 은 이지만 범위가 달라서 형변환 필요
    d. float f = (float)l; // float(4byte) long(8byte) 의 범위가 보다 커서 생략가능
    e. i = (int)ch; // char(2 byte) int(4byte) → 이므로 생략가능
    
- 2-10
    
    char 타입의 변수에 저장될 수 있는 정수 값의 범위는? (10진수로 적으시오)
    
    0~65535
    
    char 타입은 2byte = 16bit이므로 ‘2의 16제곱’개의 값을 표현 가능
    
- 2-11
    
    다음 중 변수를 잘못 초기화 한 것은? (모두 고르시오)
    a. byte b = 256;
    b. char c = '';
    c. char answer = 'no';
    d. float f = 3.14
    e. double d = 1.4e3f;
    
    a, d → a,b,c,d
    
    byte의 범위 -128 ~ 127
    
    char는 ‘’ 안에 반드시 “한 개”의 문자를 지정해야한다. 두 개 이상은 올 수 없다.
    
    접미사가 있는 자료형은 long, float, double 모두 세 개이며 대소문자를 구별하지 않는다.
    
    double(8byte)에 float(4byte)를 넣는 것은 허용 가능
    
- 2-12
    
    다음 중 main메서드의 선언부로 알맞은 것은? (모두 고르시오)
    
    a. public static void main(String[] args)
    b. public static void main(String args[])
    c. public static void main(String[] arv)
    d. public void static main(String[] args)
    e. static public void main(String[] args)
    
    a,b → a,b,c,e
    
    매개변수 args의 이름은 달라도 된다.
    
    public과 static은 위치가 바뀌어도 된다.
    
- 2-13
    
    다음 중 타입과 기본값이 잘못 연결된 것은? (모두 고르시오)
    
    a. boolean - false
    b. char - '\u0000'
    c. float - 0.0
    d. int - 0
    e. long - 0
    f. String - ""
    
    b → c,e,f
    
    float 기본값: 0.0f   0.0은 0.0d에서 접미사 d가 생략된 것이다.
    
    long 기본값: 0L
    
    String은 참조형타입. 모든 참조형 타입의 기본값은 null
