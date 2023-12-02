@file:Suppress("UnnecessaryVariable")

package academy.kt

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated

class MyGenerator(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        return resolver
            .getSymbolsWithAnnotation(MyAnnotation::class.qualifiedName!!)
            .filter {
                logger.warn("Found @MyAnnotation annotation on $it")
                false
            }
            .toList()
    }
}
