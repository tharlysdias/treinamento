package com.proway.treinamento;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.proway.treinamento");

        noClasses()
            .that()
            .resideInAnyPackage("com.proway.treinamento.service..")
            .or()
            .resideInAnyPackage("com.proway.treinamento.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.proway.treinamento.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
