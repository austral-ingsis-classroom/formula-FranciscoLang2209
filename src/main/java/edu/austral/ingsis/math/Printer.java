package edu.austral.ingsis.math;

public class Printer implements Visitor {
    private final StringBuilder result = new StringBuilder();

    @Override
    public void visit(Addition sum) {
        result.append("(");
        sum.getLeft().accept(this);
        result.append(" + ");
        sum.getRight().accept(this);
        result.append(")");
    }

    @Override
    public void visit(Subtraction subtraction) {
        result.append("(");
        subtraction.getLeft().accept(this);
        result.append(" - ");
        subtraction.getRight().accept(this);
        result.append(")");
    }

    @Override
    public void visit(Multiplication multiplication) {
        result.append("(");
        multiplication.getLeft().accept(this);
        result.append(" * ");
        multiplication.getRight().accept(this);
        result.append(")");
    }

    @Override
    public void visit(Division division) {
        result.append("(");
        division.getNumerator().accept(this);
        result.append(" / ");
        division.getDenominator().accept(this);
        result.append(")");
    }

    @Override
    public void visit(Root root) {
        result.append("(");
        root.getBase().accept(this);
        result.append(") ^ (1 / 2)");
    }

    @Override
    public void visit(Exponentiation exponentiation) {
        result.append("(");
        exponentiation.getBase().accept(this);
        result.append(" ^ ");
        exponentiation.getExponent().accept(this);
        result.append(")");
    }

    @Override
    public void visit(Absolute absolute) {
        result.append("|");
        absolute.getBase().accept(this);
        result.append("|");
    }

    @Override
    public void visit(Number number) {
        result.append(number.getValue());
    }

    @Override
    public void visit(Variable variable) {
        result.append(variable.getName());
    }

    public String getResult() {
        return result.toString();
    }
}
