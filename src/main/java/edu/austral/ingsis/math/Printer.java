package edu.austral.ingsis.math;

public class Printer implements Visitor {
    @Override
    public void visit(Addition sum) {
        String result = "(" + sum.getLeft().toString() + " + " + sum.getRight().toString() + ")";
        System.out.println(result);
    }

    @Override
    public void visit(Subtraction subtraction) {
        String result = "(" + subtraction.getLeft().toString() + " - " + subtraction.getRight().toString() + ")";
        System.out.println(result);
    }

    @Override
    public void visit(Multiplication multiplication) {
        String result = "(" + multiplication.getLeft().toString() + " * " + multiplication.getRight().toString() + ")";
        System.out.println(result);
    }

    @Override
    public void visit(Division division) {
        String result = "(" + division.getNumerator().toString() + " / " + division.getDenominator().toString() + ")";
        System.out.println(result);
    }

    @Override
    public void visit(Root root) {
        String result = "( √" + root.getBase().toString() + ")";
        System.out.println(result);
    }

    @Override
    public void visit(Exponentiation exponentiation) {
        String result = "(" + exponentiation.getBase().toString() + " ^ " +
                exponentiation.getExponent().toString() + ")";
        System.out.println(result);
    }

    @Override
    public void visit(Absolute absolute) {
        String result = "( |" + absolute.getBase().toString() + "| )";
        System.out.println(result);
    }

    @Override
    public void visit(Number number) {
        System.out.println(number.getValue());
    }

    @Override
    public void visit(Variable variable) {
        System.out.println(variable.getName());
    }
}
