class Pokemon { // Created Pokemon class
    int index;
    String name;
    String typeone;
    String typetwo;
    int total;
    int hp;
    int attack;
    int defense;
    int specialatk;
    int specialdef;
    int speed;
    int generation;
    boolean legend;

    Pokemon() { // Empty constructor

    }

    // Pokemon constructor
    Pokemon(int index, String name, String typeone, String typetwo, int total, int hp, int attack, int defense, int specialatk, int specialdef, int speed, int generation, boolean legend) {
        this.index = index;
        this.name = name;
        this.typeone = typeone;
        this.typetwo = typetwo;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialatk = specialatk;
        this.specialdef = specialdef;
        this. speed = speed;
        this.generation = generation;
        this.legend = legend;
    }
    // Setters and Getters for Pokemon stat information
    public int getIndex() {
        return index;
    }

    // Setter
    public void setIndex(int newIndex) {
        this.index = newIndex;
    }
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }
    public String getTypeone() {
        return typeone;
    }

    // Setter
    public void setTypeone(String newTypeone) {
        this.typeone = newTypeone;
    }
    public String getTypetwo() {
        return typetwo;
    }

    // Setter
    public void setTypetwo(String newTypetwo) {
        this.typetwo = newTypetwo;
    }
    public int getTotal() {
        return total;
    }

    // Setter
    public void setTotal(int newTotal) {
        this.total = newTotal;
    }
    public int getHp() {
        return hp;
    }

    // Setter
    public void setHp(int newHp) {
        this.hp = newHp;
    }
    public int getAttack() {
        return attack;
    }

    // Setter
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
    public int getDefense() {
        return defense;
    }

    // Setter
    public void setDefense(int newDefense) {
        this.defense = newDefense;
    }
    public int getSpecialatk() {
        return specialatk;
    }

    // Setter
    public void setSpecialatk(int newSpecialatk) {
        this.specialatk = newSpecialatk;
    }
    public int getSpecialdef() {
        return specialdef;
    }

    // Setter
    public void setSpecialdef(int newSpecialdef) {
        this.specialdef = newSpecialdef;
    }
    public int getSpeed() {
        return speed;
    }

    // Setter
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
    public int getGeneration() {
        return generation;
    }

    // Setter
    public void setGeneration(int newGeneration) {
        this.generation = newGeneration;
    }
    public boolean getLegend() {
        return legend;
    }

    // Setter
    public void setLegend(boolean newLegend) {
        this.legend = newLegend;
    }


}

