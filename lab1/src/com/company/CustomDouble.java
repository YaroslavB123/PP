package com.company;

public class CustomDouble {
    private int integer;
    private double fractions;
    private boolean minus;

    public CustomDouble(final int integer, final double fractions) {
        setInteger(integer);
        setFractions(fractions);
    }

    public CustomDouble(final int integer) {
        setInteger(integer);
    }

    public CustomDouble() {
    }

    public boolean isMinus() {
        return minus;
    }

    public void setMinus(final boolean minus) {
        this.minus = minus;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(final int integer) {
        if (integer < 0) {
            setMinus(true);
        }

        this.integer = Math.abs(integer);
    }

    public double getFractions() {
        return fractions;
    }

    public void setFractions(final double fractions) {
        if (fractions < 0) {
            setMinus(true);
        }

        if (Math.abs(fractions) >= 1) {
            this.fractions = Math.abs(fractions) % 1;
            setInteger((int) fractions + getInteger());
        } else {
            this.fractions = Math.abs(fractions);
        }
    }

    public CustomDouble add(final CustomDouble b) {
        final CustomDouble res = new CustomDouble();

        final double result = this.toDouble() + b.toDouble();

        res.setInteger((int) (result));
        res.setFractions(result % 1);

        return res;
    }

    public CustomDouble subtraction(final CustomDouble b) {
        final CustomDouble res = new CustomDouble();

        final double result = this.toDouble() - b.toDouble();

        res.setInteger((int) (result));
        res.setFractions(result % 1);

        return res;
    }
    public CustomDouble multiplication(final CustomDouble b) {
        final CustomDouble res = new CustomDouble();

        final double result = this.toDouble() * b.toDouble();

        res.setInteger((int) result);
        res.setFractions(result % 1);

        return res;
    }

    public CustomDouble divide(final CustomDouble b) {
        final CustomDouble res = new CustomDouble();

        if (b.toDouble() == 0) {
            throw new ArithmeticException("На нуль не ділиться");
        }

        final double result = this.toDouble() / b.toDouble();

        res.setInteger((int) result);
        res.setFractions(result % 1);

        return res;
    }

    public double toDouble() {
        double res = this.fractions + this.integer;
        if (this.minus) {
            res *= -1;
        } else {
            res *= 1;
        }

        return res;
    }

    public boolean greaterEqual(final CustomDouble b) {
        return this.toDouble() == b.toDouble();
    }

    public boolean greaterMax(final CustomDouble b) {
        return this.toDouble() > b.toDouble();
    }

    public boolean greaterMin(final CustomDouble b) {
        return this.toDouble() < b.toDouble();
    }

    @Override
    public String toString() {
        return "Figure {" +
                "integer=" + integer +
                ", fractions=" + fractions +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o.getClass() == this.getClass())) return false;
        final CustomDouble that = (CustomDouble) o;
        return getInteger() == that.getInteger()
                && that.getFractions() == getFractions()
                && isMinus() == that.isMinus();
    }

    @Override
    public int hashCode() {
        return getInteger() + (int) getFractions() + Boolean.hashCode(isMinus());
    }

    public static void main(final String[] args) {
        try {
            final CustomDouble task1 = new CustomDouble(-2, -0.3);
            final CustomDouble task2 = new CustomDouble(4, 0.8);

            System.out.println(task1.subtraction(task2).toDouble());
            System.out.println(task1.add(task2).toDouble());
        }
        catch (final ArithmeticException e)
        {
            System.out.println(e.getMessage());

        }
    }
}
