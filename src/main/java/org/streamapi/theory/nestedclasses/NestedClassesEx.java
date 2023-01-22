package org.streamapi.theory.nestedclasses;

/**
 * Существует четыре категории вложенных классов:
 * <p>
 * 1. Статические вложенные классы и не статические вложенные классы.
 * Вложенные классы, объявленные статически, называются вложенными статическими классами.
 * 2. Внутренние классы — когда объект внутреннего класса связан с объектом обрамляющего класса.
 * Не статические вложенные классы называются внутренними классами, если они связанны с внешним классом.
 * 3. Локальные классы — объявленные внутри блока кода и не являющиеся членом обрамляющего класса.
 * В этом случае можно рассматривать класс как локальную переменную типа класс.
 * 4. Анонимные классы – наследуемые, от какого либо класса, классы в которых при объявлении не задано имя класса.
 * <p>
 * Зачем использовать вложенные классы?
 * Причины использования вложенных классов такие. Если класс полезен только для одного другого класса,
 * то вполне логично встроить его в этот класс и хранить их вместе.
 * Использование вложенных классов увеличивает инкапсуляцию.
 */

// NestedClassesEx - top lvl class принадлежит пакету
public class NestedClassesEx {

    // 1. статичный вложенный класс static nested class
    static class A {
    }

    // 2. вложенный класс inner class
    class B {
    }

    // 3. local class локальный класс
    void method() {
        class C {
        }
    }
    // 4. анонимные классы
}
