"use strict";
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (Object.hasOwnProperty.call(mod, k)) result[k] = mod[k];
    result["default"] = mod;
    return result;
}
Object.defineProperty(exports, "__esModule", { value: true });
var child_process = __importStar(require("child_process"));
var fs = __importStar(require("fs"));
var TAM = /** @class */ (function () {
    function TAM() {
    }
    TAM.parse = function (fileName) {
        var shellResult = child_process.execSync("./launch.sh tests/inputs/" + fileName + " 2");
        return JSON.parse(shellResult.toString());
    };
    TAM.execute = function (tam) {
        fs.writeFileSync('tmp.tam', tam);
        child_process.execSync("java -jar tools/aspartam.jar tmp.tam >/dev/null 2>&1");
        child_process.execSync("java -jar tools/tammachine.jar tmp.tamo > tmp.res 2>&1");
        var r = fs.readFileSync("tmp.res")
            .toString()
            .replace(/Execution de (.+)\n/, "")
            .trim();
        return r.split("\n");
    };
    TAM.parseAndExecute = function (fileName) {
        return TAM.execute(TAM.parse(fileName).TAM);
    };
    return TAM;
}());
exports.TAM = TAM;
