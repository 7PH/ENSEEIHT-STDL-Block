import {TAM} from "./TAM";

describe('tests', function() {

    this.slow(500);

    describe('# print', function () {
        it('integer', function (done: any) {
            let a: string[] = TAM.parseAndExecute('print.txt');

            if (parseInt(a[0]) !== 11 || parseInt(a[1]) !== 20 || parseInt(a[2]) !== 15)
                throw new Error("Invalid result - " + a.join(", "));

            done();
        });
    });

    describe('# ternary operator', function () {
        it('full test', function (done: any) {
            let a: string[] = TAM.parseAndExecute('ternary.txt');

            if (parseInt(a[0]) !== 1 || parseInt(a[1]) !== 3)
                throw new Error("Invalid result - " + a.join(", "));

            done();
        });
    });
});