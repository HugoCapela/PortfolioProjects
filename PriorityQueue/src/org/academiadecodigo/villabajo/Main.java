package org.academiadecodigo.villabajo;

/**
 * <Academia de Código_> #87 FLOWribellas
 *
 * Bootcamp Week #5 - Java Collections
 *
 * Pair programming with João Batista
 */
public class Main {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todoList.add(TodoList.Importance.LOW, 2, "Do Dishes");
        todoList.add(TodoList.Importance.LOW, 1, "Do something");
        todoList.add(TodoList.Importance.HIGH, 1, "Eat");
        todoList.add(TodoList.Importance.MEDIUM, 10, "Wash clothes");
        todoList.add(TodoList.Importance.HIGH, 2, "Sleep");
        todoList.add(TodoList.Importance.MEDIUM, 2, "Walk dog");

        while( !todoList.isEmpty() ) {
            System.out.println(todoList.remove());
        }
    }
}
