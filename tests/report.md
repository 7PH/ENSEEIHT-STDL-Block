# TOC
   - [getType()](#gettype)
     - [# AtomicType](#gettype--atomictype)
       - [# Declaration](#gettype--atomictype--declaration)
       - [# Assignment](#gettype--atomictype--assignment)
     - [# RecordType](#gettype--recordtype)
     - [# PointerType](#gettype--pointertype)
     - [# Functions](#gettype--functions)
     - [# If](#gettype--if)
     - [# While](#gettype--while)
     - [# Valid examples](#gettype--valid-examples)
   - [execute()](#execute)
     - [# BinaryExpression](#execute--binaryexpression)
     - [# Printer](#execute--printer)
     - [# TernaryExpression](#execute--ternaryexpression)
     - [# Pointer](#execute--pointer)
     - [# NamedType](#execute--namedtype)
     - [# Record](#execute--record)
     - [# Array](#execute--array)
     - [# While](#execute--while)
     - [# String](#execute--string)
     - [# Functions](#execute--functions)
       - [f: () => any](#execute--functions-f---any)
       - [f: (a: any) => any](#execute--functions-f-a-any--any)
       - [f: (a: any, b: any) => any](#execute--functions-f-a-any-b-any--any)
<a name=""></a>
 
<a name="gettype"></a>
# getType()
<a name="gettype--atomictype"></a>
## # AtomicType
<a name="gettype--atomictype--declaration"></a>
### # Declaration
IntegerType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("int a = \"1\";", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int a = \"1\";", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int a = '1';", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int a = true;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int a = {1};", { resolve: true, checkType: false });
done();
```

CharacterType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("character a = \"c\";", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("character a = 1;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("character a = true;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("character a = {'c'};", { resolve: true, checkType: false });
done();
```

StringType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("String a = 'H';", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("String a = 1;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("String a = true;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("String a = {\"Hello\"};", { resolve: true, checkType: false });
done();
```

BooleanType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("boolean a = '1';", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("boolean a = 1;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("boolean a = \"true\";", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("boolean a = {true};", { resolve: true, checkType: false });
done();
```

CoupleType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("<int, int> a = <\"a\", 1>;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("<<int, boolean>, character> a = <<1, false>, 3>;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int b = 1; <int, boolean> a = <1, b>;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("<int, int> a = {1, 1};", { resolve: true, checkType: false });
done();
```

<a name="gettype--atomictype--assignment"></a>
### # Assignment
IntegerType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("int a = 0; a = \"1\";", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int a = 0; a = '1';", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int a = 0; a = true;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int a = 0; a = {1};", { resolve: true, checkType: false });
done();
```

CharacterType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("character a = 'a'; a = \"c\";", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("character a = 'a'; a = 1;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("character a = 'a'; a = true;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("character a = 'a'; a = {'c'};", { resolve: true, checkType: false });
done();
```

StringType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("String a = \"a\"; a = 'H';", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("String a = \"a\"; a = 1;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("String a = \"a\"; a = true;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("String a = \"a\"; a = {\"HH\"};", { resolve: true, checkType: false });
done();
```

BooleanType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("boolean a = true; a = '1';", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("boolean a = true; a = 1;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("boolean a = true; a = \"true\";", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("boolean a = true; a = {true};", { resolve: true, checkType: false });
done();
```

CoupleType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("<int, int> a = <0, 0>; a = <\"a\", 1>;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("<<int, boolean>, character> a = <<1, true>, 2>; a = <<1, false>, 3>;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("int b = 1; <int, boolean> a = <0, true>; a = <1, b>;", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("<int, int> a = <0, 0>; a = {1, 2};", { resolve: true, checkType: false });
done();
```

RecordType (invalid - 4 tests).

```js
this.slow(testSlow * 4);
TAM_1.TAM.ensureResult("struct A{int x; int y;} a = {0, 0}; a = {1, 'a'};", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("struct A{boolean x; int y;} a = {false, 0}; a = {1, true};", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("struct A{int x; int y;} a = {0, 0}; a = {true, 0};", { resolve: true, checkType: false });
TAM_1.TAM.ensureResult("struct A{int x; int y;} a = {0, 0}; a = {{1, 0}};", { resolve: true, checkType: false });
done();
```

<a name="gettype--recordtype"></a>
## # RecordType
wrong assignement 1.

```js
TAM_1.TAM.ensureResult("struct A{int x; int y;} a = {1, 'a'};", { resolve: true, checkType: false });
done();
```

wrong assignement 2.

```js
TAM_1.TAM.ensureResult("struct A{boolean x; int y;} a = {1, true};", { resolve: true, checkType: false });
done();
```

wrong assignement 3.

```js
TAM_1.TAM.ensureResult("struct A{int x; int y;} a = {true, 0};", { resolve: true, checkType: false });
done();
```

struct containing struct.

```js
TAM_1.TAM.ensureResult("\n                    typedef struct SPoint {int x; int y;} Point;\n                    struct Circle {Point center; int radius;} circle = {{0, 1}, 10};\n                ", { resolve: true, checkType: true });
done();
```

struct invalid access.

```js
TAM_1.TAM.ensureResult("\n                    typedef struct SPoint {int x; int y;} Point;\n                    Point point = {1, 2};\n                    int a = point.foo;\n                ", { resolve: false, checkType: false });
done();
```

struct access with invalid type.

```js
TAM_1.TAM.ensureResult("\n                    typedef struct SPoint {int x; int y;} Point;\n                    Point point = {1, 2};\n                    character a = point.x;\n                ", { resolve: true, checkType: false });
done();
```

struct valid access.

```js
TAM_1.TAM.ensureResult("\n                    typedef struct SPoint {int x; int y;} Point;\n                    Point point = {1, 2};\n                    int a = point.x;\n                ", { resolve: true, checkType: true });
done();
```

<a name="gettype--pointertype"></a>
## # PointerType
wrong assignement.

```js
TAM_1.TAM.ensureResult("\n                character a = 'c';\n                int *ptr = &a;\n                ", { resolve: true, checkType: false });
done();
```

reference getter.

```js
TAM_1.TAM.ensureResult("\n                int a = 1;\n                int b = 2;\n                int c = 3;\n                int *ptr = &b;\n                *ptr = 42;\n                ", { resolve: true, checkType: true });
done();
```

basic pointer declaration and assignement.

```js
TAM_1.TAM.ensureResult("int *ptr = new int(); *ptr = 1;", { resolve: true, checkType: true });
done();
```

basic pointer.

```js
TAM_1.TAM.ensureResult("int *ptr = new int(); *ptr = 1;", { resolve: true, checkType: true });
done();
```

pointer of named type -> record type.

```js
TAM_1.TAM.ensureResult("\n                typedef <int, int> Point;\n                Point *ptr = new Point();\n                *ptr = <1, 2>;\n                int a = fst (*ptr);\n                int b = snd (*ptr);\n                print a;\n                print b;\n                ", { resolve: true, checkType: true });
done();
```

<a name="gettype--functions"></a>
## # Functions
Wrong return type 1.

```js
TAM_1.TAM.ensureResult("int f() { int a = 1; if (a > 0) { return 1; } else { return 'a'; } }", { resolve: true, checkType: false });
done();
```

Wrong return type 2.

```js
TAM_1.TAM.ensureResult("int f() { int a = 1; if (a > 0) { return 'a'; } else { return 1; } }", { resolve: true, checkType: false });
done();
```

Function returning a NamedType.

```js
TAM_1.TAM.ensureResult("\n                    typedef struct SPoint {int x; int y;} Point;\n                    Point f(int a) {\n                        return {a, a};\n                    }\n                ", { resolve: true, checkType: true });
done();
```

Unreachable statement.

```js
TAM_1.TAM.ensureResult("int f() { return 1; return 2; }", { resolve: false, checkType: true });
done();
```

Unreachable statement and wrong return type.

```js
TAM_1.TAM.ensureResult("int f() { return 1; return 'a'; }", { resolve: false, checkType: false });
done();
```

<a name="gettype--if"></a>
## # If
if ({not boolean}) { .. }.

```js
TAM_1.TAM.ensureResult("if (1) { }", { resolve: true, checkType: false });
done();
```

<a name="gettype--while"></a>
## # While
while ({not boolean}) { .. }.

```js
TAM_1.TAM.ensureResult("while (1) { }", { resolve: true, checkType: false });
done();
```

<a name="gettype--valid-examples"></a>
## # Valid examples
full basic example (valid).

```js
TAM_1.TAM.ensureResult("\n                // com 1\n                <<int, boolean>, character> hello = <<1, false>, 'a'>;\n                typedef struct SB {boolean active;} B;\n                struct A{int x; int y; B target;} world = {-1, 1, {true}};\n                int a = 6;\n                boolean even = (a + 1) % 2 == 0;\n                int i = 1;\n                character g = 'a';\n                const int j = 2;\n                <int, int> p = <3, 4>;\n                int k = fst p;\n                \n                /* com 2 */\n                if (i >= 2) {\n                    i = i - i * 2;\n                }\n            \n                if (i < 5) {\n                    int j = 5;\n                    j = i * (snd p);\n                    i = j + 1;\n            \n                    while (k < 10) {\n                        int p = 3;\n                        k = k + 1;\n                    }\n            \n                } else {\n            \n                    if (i + j < 10) {\n                        const boolean p = false;\n                        print p;\n                    }\n                    print fst p;\n                }\n            \n                print j;\n            ", {
    resolve: true,
    checkType: true
});
done();
```

complex example (valid).

```js
TAM_1.TAM.ensureResult("\n                typedef <int, int> Point;\n                typedef struct SCircle {<int, int> center; int radius;} Circle;\n                Circle circle = {<-1, 1>, 2};\n            ", {
    resolve: true,
    checkType: true
});
done();
```

<a name="execute"></a>
# execute()
<a name="execute--binaryexpression"></a>
## # BinaryExpression
+ * % / < > <= >= || && ...

```js
TAM_1.TAM.ensureResult("\n                int a = 10;\n                int b = 20;\n                int c = a - b; // -10\n                int d = c + b * 4 / 2; // 30\n                \n                int e = b % 15; // 5\n                boolean f = e > 4; // true\n                boolean g = e < 4; // false\n                boolean h = e <= 3; // false\n                \n                boolean i = e >= 3; // true\n                boolean j = f || g; // true\n                boolean k = f && g; // false\n                \n                print a; print b; print c; print d;\n                print e; print f; print g; print h;\n                print i; print j; print k;\n            ", {
    resolve: true,
    checkType: true,
    output: ['10', '20', '-10', '30', '5', '1', '0', '0', '1', '1', '0']
});
done();
```

print {constant:int}.

```js
TAM_1.TAM.ensureResult("\n                const int a = -1;\n                print a;\n            ", {
    resolve: true,
    checkType: true,
    output: ['-1']
});
done();
```

<a name="execute--printer"></a>
## # Printer
print {variable:int}.

```js
TAM_1.TAM.ensureResult("\n                int a = 10;\n                int b = 20;\n                print b;\n                print a;\n                print b;\n            ", {
    resolve: true,
    checkType: true,
    output: ['20', '10', '20']
});
done();
```

print {constant:int}.

```js
TAM_1.TAM.ensureResult("\n                const int a = -1;\n                print a;\n            ", {
    resolve: true,
    checkType: true,
    output: ['-1']
});
done();
```

print {character}.

```js
TAM_1.TAM.ensureResult("\n                const character a = 'c';\n                print a;\n            ", {
    resolve: true,
    checkType: true,
    output: ['\'c\'']
});
done();
```

print {boolean}.

```js
TAM_1.TAM.ensureResult("\n                boolean a = true;\n                print a;\n                a = false;\n                print a;\n            ", {
    resolve: true,
    checkType: true,
    output: ['1', '0']
});
done();
```

print {NamedType}.

```js
TAM_1.TAM.ensureResult("\n                typedef int Entier;\n                Entier a = 2;\n                print a;\n            ", {
    resolve: true,
    checkType: true,
    output: ['2']
});
done();
```

print {String}.

```js
TAM_1.TAM.ensureResult("\n                String c1 = \"str1\";\n                String c2 = \"str2\";\n                String c3 = \"str3\";\n                print c1;\n                print c3;\n                print c2;\n            ", {
    resolve: true,
    checkType: true,
    output: ['"str1"', '"str3"', '"str2"']
});
done();
```

<a name="execute--ternaryexpression"></a>
## # TernaryExpression
a ? b : c.

```js
TAM_1.TAM.ensureResult("\n                int a = true ? 1 : 2;\n                int b = a <= 1 ? 0 : 1;\n                print b;\n            ", {
    resolve: true,
    checkType: true,
    output: ['0']
});
done();
```

a ? (b ? c : d) : (e ? f : g).

```js
TAM_1.TAM.ensureResult("\n                int a = true ? 1 : 2;\n                int b = a > 1 ? (a > 2 ? 0 : 1) : (a < 0 ? 2 : 3);\n                print a;\n                print b;\n            ", {
    resolve: true,
    checkType: true,
    output: ['1', '3']
});
done();
```

<a name="execute--pointer"></a>
## # Pointer
reference getter.

```js
TAM_1.TAM.ensureResult("\n                int a = 1;\n                int b = 2;\n                int c = 3;\n                int *ptr = &b;\n                *ptr = 42;\n                print a;\n                print b;\n                print c;\n                print *ptr;\n                ", { resolve: true, checkType: true, output: ['1', '42', '3', '42'] });
done();
```

pointer of named type -> record type.

```js
TAM_1.TAM.ensureResult("\n                typedef <int, int> Point;\n                Point *ptr = new Point();\n                *ptr = <1, 2>;\n                int a = fst (*ptr);\n                int b = snd (*ptr);\n                print a;\n                print b;\n                ", { resolve: true, checkType: true, output: ['1', '2'] });
done();
```

basic usage.

```js
TAM_1.TAM.ensureResult("\n                int *ptr = new int();\n                *ptr = 2;\n                print *ptr;\n            ", { resolve: true, checkType: true, output: ['2'] });
done();
```

shared pointer.

```js
TAM_1.TAM.ensureResult("\n                int *ptr = new int();\n                *ptr = 2;\n                int *addr = ptr;\n                *ptr = 4;\n                print *addr;\n            ", { resolve: true, checkType: true, output: ['4'] });
done();
```

<a name="execute--namedtype"></a>
## # NamedType
declaration and assignement.

```js
TAM_1.TAM.ensureResult("\n                typedef int entier;\n                entier a = 2;\n                print a;\n            ", {
    resolve: true,
    checkType: true,
    output: ['2']
});
done();
```

<a name="execute--record"></a>
## # Record
access.

```js
TAM_1.TAM.ensureResult("\n                struct SCircle {int x; int y; int radius;} circle = {1, 2, 3};\n                print circle.y;\n                print circle.x;\n                print circle.radius;\n            ", {
    resolve: true,
    checkType: true,
    output: ['2', '1', '3']
});
done();
```

<a name="execute--array"></a>
## # Array
int a[] = new int[2].

```js
TAM_1.TAM.ensureResult("\n                int a[] = new int[2];\n                a[0] = 8;\n                a[1] = 4;\n                print a[0];\n                print a[1];\n            ", {
    resolve: true,
    checkType: true,
    output: ['8', '4']
});
done();
```

complex example.

```js
TAM_1.TAM.ensureResult("\n                int a[] = new int[2];\n                a[0] = 8;\n                a[1] = 4;\n                \n                int b = 10; // to fill stack\n                \n                int e[] = new int[3];\n                e[1] = 2;\n                e[0] = 1;\n                e[2] = a[1] - 1;\n                \n                int f = e[2];\n                \n                print a[0]; print a[1];\n                print b;\n                print e[0]; print e[1]; print f;\n                \n            ", {
    resolve: true,
    checkType: true,
    output: ['8', '4', '10', '1', '2', '3']
});
done();
```

Array<Record(int, int)>.

```js
TAM_1.TAM.ensureResult("\n                typedef struct SPoint {int x; int y;} Point;\n                Point a[] = new Point[2];\n                a[0] = {0, 1};\n                a[1] = {2, 3};\n                print a[0].x;\n                print a[0].y;\n                print a[1].y;\n                print a[1].x;\n            ", {
    resolve: true,
    checkType: true,
    output: ['0', '1', '3', '2']
});
done();
```

Array<Record(<int, boolean>, char)>.

```js
TAM_1.TAM.ensureResult("\n                typedef struct SS {<int, boolean> a; int b;} S;\n                S a[] = new S[2];\n                a[0] = {<1, true>, 2};\n                a[1] = {<3, false>, 4};\n                int r1 = fst (a[0].a);\n                boolean r2 = snd (a[0].a);\n                int r3 = a[0].b;\n                int r4 = fst (a[1].a);\n                boolean r5 = snd (a[1].a);\n                int r6 = a[1].b;\n                print r1;\n                print r2;\n                print r3;\n                print r4;\n                print r5;\n                print r6;\n            ", {
    resolve: true,
    checkType: true,
    output: ['1', '1', '2', '3', '0', '4']
});
done();
```

<a name="execute--while"></a>
## # While
int i = 0; while (i < N) { ++i; }.

```js
TAM_1.TAM.ensureResult("\n                const int N = 4;\n                int i = 0;\n                while (i < N) {\n                    print i;\n                    i = i + 1;\n                }\n            ", {
    resolve: true,
    checkType: true,
    output: ['0', '1', '2', '3']
});
done();
```

while (..) { while (..) { .. } }.

```js
TAM_1.TAM.ensureResult("\n                const int N = 2;\n                int i = 0;\n                while (i < N) {\n                    int j = 0;\n                    while (j < N) {\n                        // do stuff\n                        print j;\n                        j = j + 1;\n                    }\n                    i = i + 1;\n                }\n            ", {
    resolve: true,
    checkType: true,
    output: ['0', '1', '0', '1']
});
done();
```

<a name="execute--string"></a>
## # String
affectations.

```js
TAM_1.TAM.ensureResult("\n                String c1 = \"str1\";\n                String c2 = c1;\n                c1 = \"str4\";\n                print c2;\n            ", {
    resolve: true,
    checkType: true,
    output: ['"str1"']
});
done();
```

concatenation.

```js
TAM_1.TAM.ensureResult("\n                String a = \"Hello\";\n                String b = \" \";\n                String c = \"World\";\n                String d = a..b..c;\n                print d;\n            ", {
    resolve: true,
    checkType: true,
    output: ['"Hello World"']
});
done();
```

comparaison test.

```js
TAM_1.TAM.ensureResult("\n                String a = \"Hello\";\n                String b = \"Hello\";\n                boolean c = a == b; // comparaison are made by address\n                print c;\n            ", {
    resolve: true,
    checkType: true,
    output: ['0']
});
done();
```

<a name="execute--functions"></a>
## # Functions
<a name="execute--functions-f---any"></a>
### f: () => any
local variables.

```js
TAM_1.TAM.ensureResult("\n                int f() {\n                    int a = 1;\n                    int b = 2;\n                    return a + b;\n                }\n                int a = f();\n                print a;\n                ", { resolve: true, checkType: true, output: ['3'] });
done();
```

function calling another.

```js
TAM_1.TAM.ensureResult("\n                int f1() {\n                    return 20;\n                }\n                int f2() {\n                    return 1 + f1();\n                }\n                int a = f2();\n                print a;\n                ", { resolve: true, checkType: true, output: ['21'] });
done();
```

local variables in nested functions.

```js
TAM_1.TAM.ensureResult("\n                int f1() {\n                    return 20;\n                }\n                int f2() {\n                    return 1 + f1();\n                }\n                int a = f2();\n                print a;\n                ", { resolve: true, checkType: true, output: ['21'] });
done();
```

multiple returns in one function.

```js
TAM_1.TAM.ensureResult("\n                    int a = 1;\n                    \n                    int f() {\n                        if (a < 0) {\n                            return 1;\n                        } else {\n                            if (a < 10) {\n                                return 2;\n                            } else {\n                                return 3;\n                            }\n                        }\n                    }\n                    \n                    a = -1; print f();\n                    a = 1; print f();\n                    a = 20; print f();\n                ", { resolve: true, checkType: true, output: ['1', '2', '3'] });
done();
```

returning complex values.

```js
TAM_1.TAM.ensureResult("\n                    typedef struct SPoint {int x; int y;} Point;\n                    \n                    Point getReferential() {\n                        return {1, 4};\n                    }\n                    \n                    Point point = getReferential();\n                    print point.x;\n                    print point.y;\n                ", { resolve: true, checkType: true, output: ['1', '4'] });
done();
```

<a name="execute--functions-f-a-any--any"></a>
### f: (a: any) => any
identity function.

```js
TAM_1.TAM.ensureResult("\n                    // noise for filling the stack\n                    int a = 1;\n                    int b = 1;\n                    \n                    int func(int a) {\n                        return a;\n                    }\n                    \n                    // noise\n                    int c = 1;\n                    int d = 1;\n                    \n                    int e = func(3);\n                    print e;\n                ", { resolve: true, checkType: true, output: ['3'] });
done();
```

with local variable.

```js
TAM_1.TAM.ensureResult("\n                    // noise for filling the stack\n                    int a = 1;\n                    int b = 1;\n                    \n                    int add5(int a) {\n                        int add = 5;\n                        return a + add;\n                    }\n                    \n                    // noise\n                    int c = 1;\n                    int d = 1;\n                    \n                    int e = add5(5);\n                    print e;\n                ", { resolve: true, checkType: true, output: ['10'] });
done();
```

nested functions with local variables.

```js
TAM_1.TAM.ensureResult("\n                    // noise for filling the stack\n                    int a = 1;\n                    int b = 1;\n                    \n                    int add5(int a) {\n                        int add = 5;\n                        return a + add;\n                    }\n                    int add10(int a) {\n                        int add = 5;\n                        return add + add5(a);\n                    }\n                    \n                    // noise\n                    int c = 1;\n                    int d = 1;\n                    \n                    int e = add10(5);\n                    print e;\n                ", { resolve: true, checkType: true, output: ['15'] });
done();
```

recursive (factorial).

```js
TAM_1.TAM.ensureResult("\n                    int fact(int n) {\n                        if (n <= 1) {\n                            return 1;\n                        } else {\n                            return n * fact(n - 1);\n                        }\n                    }\n                \n                    int a = fact(3);\n                    print a;\n                    ", { resolve: true, checkType: true, output: ['6'] });
done();
```

<a name="execute--functions-f-a-any-b-any--any"></a>
### f: (a: any, b: any) => any
sum.

```js
TAM_1.TAM.ensureResult("\n                    int sum(int a, int b) {\n                        return a + b;\n                    }\n                    \n                    print sum(1, 3);\n                    print sum(3, 4);\n                    ", { resolve: true, checkType: true, output: ['4', '7'] });
done();
```

different scope access.

```js
TAM_1.TAM.ensureResult("\n                    int a = 1;\n                    const int b = 10;\n                    \n                    int f(int c) {\n                        int d = 100;\n                        return a + b + c + d;\n                    }\n                    \n                    print f(1000);\n                    ", { resolve: true, checkType: true, output: ['1111'] });
done();
```

different scope access in nested functions.

```js
TAM_1.TAM.ensureResult("\n                    int a = -1;\n                    \n                    int f1(int a, int b) {\n                        int f2(int a, int b) {\n                            int e = 10;\n                            return a * 10 + b;\n                        }\n                        \n                        int result1 = f2(b, a); // 21\n                        return result1;\n                    }\n                    \n                    print f1(1, 2);\n                    ", { resolve: true, checkType: true, output: ['21'] });
done();
```

with complex return type and complex parameter types.

```js
TAM_1.TAM.ensureResult("\n                    \n                    typedef struct SPoint {int x; int y;} Point;\n                    \n                    Point getCenter(Point point1, Point point2) {\n                        int x = (point1.x + point2.x) / 2;\n                        int y = (point1.y + point2.y) / 2;\n                        return {x, y};\n                    }\n                    \n                    Point p1 = {0, 0};\n                    Point p2 = {10, 20};\n                    Point center = getCenter(p1, p2);\n                    print center.x;\n                    print center.y;       \n                    ", { resolve: true, checkType: true, output: ['5', '10'] });
done();
```

