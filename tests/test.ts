import {TAM} from "./TAM";



const testSlow: number = 1000;

describe('getType()', function () {
    // slow test <=> takes more than 1 second
    this.slow(testSlow);
    this.timeout(10000);

    describe('# declaration', function () {
        it('integer (invalid - 3 tests)', function (done: () => any) {
            this.slow(testSlow * 3);
            TAM.ensureResult(`int a = "1";`, {resolve: true, checkType: false});
            TAM.ensureResult(`int a = '1';`, {resolve: true, checkType: false});
            TAM.ensureResult(`int a = true;`, {resolve: true, checkType: false});
            done();
        });

        it('character (invalid - 3 tests)', function (done: () => any) {
            this.slow(testSlow * 3);
            TAM.ensureResult(`character a = "c";`, {resolve: true, checkType: false});
            TAM.ensureResult(`character a = 1;`, {resolve: true, checkType: false});
            TAM.ensureResult(`character a = true;`, {resolve: true, checkType: false});
            done();
        });

        it('String (invalid - 3 tests)', function (done: () => any) {
            this.slow(testSlow * 3);
            TAM.ensureResult(`String a = 'H';`, {resolve: true, checkType: false});
            TAM.ensureResult(`String a = 1;`, {resolve: true, checkType: false});
            TAM.ensureResult(`String a = true;`, {resolve: true, checkType: false});
            done();
        });

        it('boolean (invalid - 3 tests)', function (done: () => any) {
            this.slow(testSlow * 3);
            TAM.ensureResult(`boolean a = '1';`, {resolve: true, checkType: false});
            TAM.ensureResult(`boolean a = 1;`, {resolve: true, checkType: false});
            TAM.ensureResult(`boolean a = "true";`, {resolve: true, checkType: false});
            done();
        });
    });

    describe('# full working example', function() {
        it('must be ok', function (done: () => any) {
            TAM.ensureResult(`    // com 1
                int a = 6;
                boolean even = (a + 1) % 2 == 0;
                int i = 1;
                character g = 'a';
                const int j = 2;
                <int, int> p = <3, 4>;
                int k = fst p;
            
                /* com 2 */
                if (i >= 2) {
                    i = i - i * 2;
                }
            
                if (i < 5) {
                    int j = 5;
                    j = i * (snd p);
                    i = j + 1;
            
                    while (k < 10) {
                        int p = 3;
                        k = k + 1;
                    }
            
                } else {
            
                    if (i + j < 10) {
                        const boolean p = false;
                        print p;
                    }
                    print p;
                }
            
                print j;
            `,
                {
                    resolve: true,
                    checkType: true
                });
            done();
        });
    });
});


describe('end to end tests', function() {

    // slow test <=> takes more than 500ms
    this.slow(500);
    this.timeout(10000);


    describe('# binary expressions', function () {
        it('a + b, a * b, a % b, a > b', function (done: () => any) {
            TAM.ensureResult(`
                int a = 10;
                int b = 20;
                int c = a - b; // -10
                int d = c + b * 2; // 30
                int e = b % 15; // 5
                boolean f = e > 4; // true
                boolean g = e <= 3; // false
                   
                print a; print b; print c; print d;
                print e; print f; print g;
            `,
                {
                    resolve: true,
                    checkType: true,
                    output: ['10', '20', '-10', '30', '5', '1', '0']
                });
            done();
        });
        it('print {constant:int}', function (done: () => any) {
            TAM.ensureResult(`
                const int a = -1;
                print a;
            `, {
                resolve: true,
                checkType: true,
                output: ['-1']
            });
            done();
        });
    });


    describe('# print', function () {
        it('print {variable:int}', function (done: () => any) {
            TAM.ensureResult(`
                int a = 10;
                int b = 20;
                print b;
                print a;
                print b;
            `,
                {
                    resolve: true,
                    checkType: true,
                    output: ['20', '10', '20']
                });
            done();
        });
        it('print {constant:int}', function (done: () => any) {
            TAM.ensureResult(`
                const int a = -1;
                print a;
            `, {
                resolve: true,
                checkType: true,
                output: ['-1']
            });
            done();
        });
    });


    describe('# ternary operator', function () {
        it('a ? b : c', function (done: any) {
            TAM.ensureResult(`
                int a = true ? 1 : 2;
                int b = a <= 1 ? 0 : 1;
                print b;
            `, {
                resolve: true,
                checkType: true,
                output: ['0']
            });
            done();
        });
        it('a ? (b ? c : d) : (e ? f : g)', function (done: any) {
            TAM.ensureResult(`
                int a = true ? 1 : 2;
                int b = a > 1 ? (a > 2 ? 0 : 1) : (a < 0 ? 2 : 3);
                print a;
                print b;
            `, {
                resolve: true,
                checkType: true,
                output: ['1', '3']
            });
            done();
        });
    });


    describe('# array', function () {
        it('int a[] = new int[2]', function (done: any) {
            TAM.ensureResult(`
                int a[] = new int[2];
                a[0] = 8;
                a[1] = 4;
                print a[0];
                print a[1];
            `, {
                resolve: true,
                checkType: true,
                output: ['8', '4']
            });
            done();
        });

        it('complex example', function (done: () => any) {
            TAM.ensureResult(`
                int a[] = new int[2];
                a[0] = 8;
                a[1] = 4;
                
                int b = 10; // to fill stack
                
                int e[] = new int[3];
                e[1] = 2;
                e[0] = 1;
                e[2] = a[1] - 1;
                
                int f = e[2];
                
                print a[0]; print a[1];
                print b;
                print e[0]; print e[1]; print f;
                
            `, {
                resolve: true,
                checkType: true,
                output: ['8', '4', '10', '1', '2', '3']
            });
            done();
        })
    });


    describe('# while', function () {
        it('int i = 0; while (i < N) { ++i; }', function (done: any) {
            TAM.ensureResult(`
                const int N = 4;
                int i = 0;
                while (i < N) {
                    print i;
                    i = i + 1;
                }
            `, {
                resolve: true,
                checkType: true,
                output: ['0', '1', '2', '3']
            });
            done();
        });
    });


});