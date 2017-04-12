package Debug;

/**
 * Created by mjrt on 4/2/2017.
 */
import java.io.DataInputStream;

import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LineNumberTableAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTableAttribute;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.InstructionFactory;
import proguard.classfile.instruction.VariableInstruction;
import proguard.classfile.io.ProgramClassReader;

public class TestName {
    public static String getName(String name) throws Exception {
        String callerClzName = new Exception().getStackTrace()[1].getClassName();
        String callerMethodName = new Exception().getStackTrace()[1].getMethodName();
        int callerLineNumber = new Exception().getStackTrace()[1].getLineNumber();
        Class<?> callerClz = Class.forName(callerClzName);
        ProgramClassReader r = new ProgramClassReader(new DataInputStream(callerClz.getResourceAsStream("/" + callerClzName.replace('.', '/') + ".class")));
        ProgramClass clz = new ProgramClass();
        r.visitProgramClass(clz);
        for(ProgramMethod m : clz.methods) {
            if(m == null)
                continue;
            if(callerMethodName.equals(m.getName(clz))) {
                String lineNumRange = m.getLineNumberRange(clz);
                int index = lineNumRange.indexOf(':');
                int start = Integer.parseInt(lineNumRange.substring(0, index));
                int end = Integer.parseInt(lineNumRange.substring(index + 1));
                if(callerLineNumber >= start && callerLineNumber <= end) {
                    for(Attribute attr : m.attributes) {
                        if(attr instanceof CodeAttribute) {
                            CodeAttribute code = (CodeAttribute) attr;
                            LineNumberTableAttribute lineNumberTable = (LineNumberTableAttribute) code.getAttribute(clz, "LineNumberTable");
                            for(int i = 0; i < lineNumberTable.u2lineNumberTableLength; i++) {
                                if(lineNumberTable.lineNumberTable[i].u2lineNumber == callerLineNumber) {
                                    int codeEnd = (i < lineNumberTable.u2lineNumberTableLength - 1) ? lineNumberTable.lineNumberTable[i + 1].u2startPC : code.code.length;
                                    Instruction prev = null;
                                    for(int z = 0; z < codeEnd;) {
                                        Instruction instruction = InstructionFactory.create(code.code, z);
                                        if(lineNumberTable.getLineNumber(z) == callerLineNumber
                                                && instruction.getName().equals("invokestatic")) {
                                            ConstantInstruction invokeStatic = (ConstantInstruction) instruction;
                                            MethodrefConstant method = (MethodrefConstant) clz.constantPool[invokeStatic.constantIndex];
                                            if(method.getName(clz).equals("getName") && method.getClassName(clz).replace('/', '.').equals(TestName.class.getName())) {
                                                VariableInstruction var = (VariableInstruction) prev;
                                                for(Attribute at : code.attributes) {
                                                    if(at instanceof LocalVariableTableAttribute) {
                                                        LocalVariableTableAttribute varTable = (LocalVariableTableAttribute) at;
                                                        LocalVariableInfo varInfo = varTable.localVariableTable[var.variableIndex];
                                                        Utf8Constant varName = (Utf8Constant) clz.constantPool[varInfo.u2nameIndex];
                                                        return varName.getString();
                                                    }
                                                }
                                            }
                                        }
                                        z += instruction.length(z);
                                        prev = instruction;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    public static String what(String name) throws Exception {
        String callerClzName = new Exception().getStackTrace()[1].getClassName();
        String callerMethodName = new Exception().getStackTrace()[1].getMethodName();
        int callerLineNumber = new Exception().getStackTrace()[1].getLineNumber();
        Class<?> callerClz = Class.forName(callerClzName);
        ProgramClassReader r = new ProgramClassReader(new DataInputStream(callerClz.getResourceAsStream("/" + callerClzName.replace('.', '/') + ".class")));
        ProgramClass clz = new ProgramClass();
        r.visitProgramClass(clz);
        for(ProgramMethod m : clz.methods) {
            if(m == null)
                continue;
            if(callerMethodName.equals(m.getName(clz))) {
                String lineNumRange = m.getLineNumberRange(clz);
                int index = lineNumRange.indexOf(':');
                int start = Integer.parseInt(lineNumRange.substring(0, index));
                int end = Integer.parseInt(lineNumRange.substring(index + 1));
                if(callerLineNumber >= start && callerLineNumber <= end) {
                    for(Attribute attr : m.attributes) {
                        if(attr instanceof CodeAttribute) {
                            CodeAttribute code = (CodeAttribute) attr;
                            LineNumberTableAttribute lineNumberTable = (LineNumberTableAttribute) code.getAttribute(clz, "LineNumberTable");
                            for(int i = 0; i < lineNumberTable.u2lineNumberTableLength; i++) {
                                if(lineNumberTable.lineNumberTable[i].u2lineNumber == callerLineNumber) {
                                    int codeEnd = (i < lineNumberTable.u2lineNumberTableLength - 1) ? lineNumberTable.lineNumberTable[i + 1].u2startPC : code.code.length;
                                    Instruction prev = null;
                                    for(int z = 0; z < codeEnd;) {
                                        Instruction instruction = InstructionFactory.create(code.code, z);
                                        if(lineNumberTable.getLineNumber(z) == callerLineNumber
                                                && instruction.getName().equals("invokestatic")) {
                                            ConstantInstruction invokeStatic = (ConstantInstruction) instruction;
                                            MethodrefConstant method = (MethodrefConstant) clz.constantPool[invokeStatic.constantIndex];
                                            if(method.getName(clz).equals("getName") && method.getClassName(clz).replace('/', '.').equals(TestName.class.getName())) {
                                                VariableInstruction var = (VariableInstruction) prev;
                                                for(Attribute at : code.attributes) {
                                                    if(at instanceof LocalVariableTableAttribute) {
                                                        LocalVariableTableAttribute varTable = (LocalVariableTableAttribute) at;
                                                        LocalVariableInfo varInfo = varTable.localVariableTable[var.variableIndex];
                                                        Utf8Constant varName = (Utf8Constant) clz.constantPool[varInfo.u2nameIndex];
                                                        return varName.getString();
                                                    }
                                                }
                                            }
                                        }
                                        z += instruction.length(z);
                                        prev = instruction;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }


}