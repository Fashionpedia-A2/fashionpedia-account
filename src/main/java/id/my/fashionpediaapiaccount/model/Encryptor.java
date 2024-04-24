package id.my.fashionpediaapiaccount.model;

import java.util.ArrayList;
import java.util.List;

public class Encryptor {
    private final List<ITransformer> steps;
    public Encryptor() {
        this.steps = new ArrayList<>();
        this.steps.add(new Shuffler(11));
        this.steps.add(new Substituter(2));
        this.steps.add(new Shifter(3));
        this.steps.add(new Reverser());
        this.steps.add(new Substituter(15));
        this.steps.add(new Shifter(5));
        this.steps.add(new Shuffler(37));
    }

    public String encrypt(String password) {
        for (ITransformer step : steps) {
            password = step.transform(password);
        }
        return password;
    }

}
