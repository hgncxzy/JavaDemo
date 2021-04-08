package com.enjoy.compiler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;


/**
 * @author xzy
 */
@SupportedAnnotationTypes({"com.xzy.ui.javademo.annotation.Lance", "com.xzy.ui.javademo.ann.Lance", "com.xzy.ui.javademo.annotation.inject.Autowired"})
public class LanceProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Messager messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE, "================================：" + set.size());
        if (!set.isEmpty()) {
            try {
                JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile("com.a.B");
                OutputStream os = sourceFile.openOutputStream();
                os.write("package com.a;\n public class B{}".getBytes());
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //xxxx
        // http
        //
        return false;
    }
}
