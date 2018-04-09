"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var TAM_1 = require("./TAM");
describe('Running all tests', function () {
    this.slow(500);
    describe('# print', function () {
        it('integer', function (done) {
            var a = TAM_1.TAM.parseAndExecute('print.txt');
            if (parseInt(a[0]) !== 11 || parseInt(a[1]) !== 20)
                throw new Error("Invalid result");
            done();
        });
    });
});
