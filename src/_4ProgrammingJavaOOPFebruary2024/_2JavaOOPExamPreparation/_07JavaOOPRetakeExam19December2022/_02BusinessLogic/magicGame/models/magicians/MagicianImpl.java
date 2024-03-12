package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.magicians;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.magics.Magic;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.common.ExceptionMessages.*;


public abstract class MagicianImpl implements Magician {
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.setMagic(magic);
        this.isAlive = true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    public void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public void takeDamage(int points) {
        int leftPoints = points;
        if (this.getProtection() < leftPoints) {
            leftPoints -= this.getProtection();
            this.setProtection(0);
            if (this.getHealth() <= 0) {
                this.setHealth(0);
                this.isAlive = false;
            } else {
                this.setHealth(this.getHealth() - leftPoints);
                if (this.getHealth() <= 0) {
                    this.setHealth(0);
                    this.isAlive = false;
                }
            }
        } else {
            setProtection(this.getProtection() - leftPoints);
                if (this.getHealth() <= 0) {
                    this.setHealth(0);
                    this.isAlive = false;
                }
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s: %s", this.getClass().getSimpleName(), this.username)).append(System.lineSeparator());
        output.append(String.format("Health: %d", this.health)).append(System.lineSeparator());
        output.append(String.format("Protection: %d", this.protection)).append(System.lineSeparator());
        output.append(String.format("Magic: %s", this.magic.getName())).append(System.lineSeparator());
        return output.toString();
    }
}
