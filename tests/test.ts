import {TAM} from "./TAM";


describe('tests', function() {

    this.slow(500);

    describe('# print', function () {
        it('integer', function (done: any) {
            TAM.ensureResult({
                resolve: true,
                checkType: true,
                output: ['11', '20', '15']
            }, 'print.txt');
            done();
        });
    });

    describe('# ternary operator', function () {
        it('full test', function (done: any) {
            TAM.ensureResult({
                resolve: true,
                checkType: true,
                output: ['1', '3']
            }, 'ternary.txt');
            done();
        });
    });


});