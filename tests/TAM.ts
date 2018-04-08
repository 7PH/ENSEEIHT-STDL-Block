import * as child_process from "child_process";
import * as fs from "fs";


export interface TAMResult {
    resolve: boolean;
    checkType: boolean;
    code: string;
    TAM: string;
}

export class TAM {

    public static parse(fileName: string): TAMResult {
        const shellResult: Buffer = child_process.execSync("./launch.sh tests/inputs/" + fileName + " 2");
        return JSON.parse(shellResult.toString());
    }

    public static execute(tam: string): string[] {
        fs.writeFileSync('tmp.tam', tam);
        child_process.execSync("java -jar tools/aspartam.jar tmp.tam >/dev/null 2>&1");
        child_process.execSync("java -jar tools/tammachine.jar tmp.tamo > tmp.res 2>&1");
        let r: string = fs.readFileSync("tmp.res")
            .toString()
            .replace(/Execution de (.+)\n/, "")
            .trim();
        return r.split("\n");
    }

    public static parseAndExecute(fileName: string): string[] {
        return TAM.execute(TAM.parse(fileName).TAM);
    }
}