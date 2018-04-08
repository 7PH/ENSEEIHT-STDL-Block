import {TAM} from "./TAM";

describe('Running all tests', function() {

    this.slow(500);

    describe('# print', function () {
        it('integer', function (done: any) {
            let a: string[] = TAM.parseAndExecute('print.txt');

            if (parseInt(a[0]) !== 11 || parseInt(a[1]) !== 20)
                done(new Error("Invalid result"));
            else
                done();
        });
    });
});