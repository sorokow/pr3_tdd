package com.example.demo;

public class Patterns {

    public int getPattern(int patternNumber){
        switch (patternNumber){
            case 0:
                adapter();
                return 0;
            case 1:
                bridge();
                return 1;
            case 2:
                composite();
                return 2;
            case 3:
                decorator();
                return 3;
            case 4:
                facade();
                return 4;
            case 5:
                flyweight();
                return 5;
            default:
                proxy();
                return 6;

        }
    }

    public void adapter(){
        System.err.println("public interface Chief\n" +
                "{\n" +
                "  public Object makeBreakfast();\n" +
                "  public Object makeLunch();\n" +
                "  public Object makeDinner();\n" +
                "}\n" +
                "\n" +
                "public class Plumber\n" +
                "{\n" +
                "  public Object getScrewNut()\n" +
                "  { ... }\n" +
                "  public Object getPipe()\n" +
                "  { ... }\n" +
                "  public Object getGasket()\n" +
                "  { ... }\n" +
                "}\n" +
                "\n" +
                "public class ChiefAdapter extends Plumber implements Chief\n" +
                "{\n" +
                "  public Object makeBreakfast()\n" +
                "  {\n" +
                "    return getGasket();\n" +
                "  }\n" +
                "  public Object makeLunch()\n" +
                "  {\n" +
                "    return getPipe();\n" +
                "  }\n" +
                "  public Object makeDinner()\n" +
                "  {\n" +
                "    return getScrewNut();\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "public class Client\n" +
                "{\n" +
                "  public static void eat(Object dish)\n" +
                "  { ... }\n" +
                "\n" +
                "  public static void main(String[] args)\n" +
                "  {\n" +
                "    Chief ch = new ChiefAdapter();\n" +
                "    Object dish = ch.makeBreakfast();\n" +
                "    eat(dish);\n" +
                "    dish = ch.makeLunch();\n" +
                "    eat(dish);\n" +
                "    dish = ch.makeDinner();\n" +
                "    eat(dish);\n" +
                "    callAmbulance();\n" +
                "  }\n" +
                "}");

    }
    public void bridge(){
        System.err.println("public interface Drawer {\n" +
                "\n" +
                "\tpublic void drawCircle(int x, int y, int radius);\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "public class SmallCircleDrawer implements Drawer{\n" +
                "\t\n" +
                "\tpublic static final double radiusMultiplier = 0.25;\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void drawCircle(int x, int y, int radius) {\n" +
                "\t\tSystem.out.println(\"Small circle center = \" + x + \",\" + y + \" radius = \" + radius*radiusMultiplier);\n" +
                "\t}\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "public class LargeCircleDrawer implements Drawer{\n" +
                "\n" +
                "\tpublic static final int radiusMultiplier = 10;\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void drawCircle(int x, int y, int radius) {\n" +
                "\t\tSystem.out.println(\"Large circle center = \" + x + \",\" + y + \" radius = \" + radius*radiusMultiplier);\n" +
                "\t}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "public abstract class Shape {\n" +
                "\n" +
                "\tprotected Drawer drawer;\n" +
                "\t\n" +
                "\tprotected Shape(Drawer drawer){\n" +
                "\t\tthis.drawer = drawer;\n" +
                "\t}\n" +
                "\t\n" +
                "\tpublic abstract void draw();\n" +
                "\t\n" +
                "\tpublic abstract void enlargeRadius(int multiplier);\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "public class Circle extends Shape{\n" +
                "\n" +
                "\tprivate int x;\n" +
                "\t\n" +
                "\tprivate int y;\n" +
                "\t\n" +
                "\tprivate int radius;\n" +
                "\t\n" +
                "\tpublic Circle(int x, int y, int radius, Drawer drawer) {\n" +
                "\t\tsuper(drawer);\n" +
                "\t\tsetX(x);\n" +
                "\t\tsetY(y);\n" +
                "\t\tsetRadius(radius);\n" +
                "\t}\n" +
                "\n" +
                "\t@Override\n" +
                "\tpublic void draw() {\n" +
                "\t\tdrawer.drawCircle(x, y, radius);\n" +
                "\t}\n" +
                "\n" +
                "\t@Override\n" +
                "\tpublic void enlargeRadius(int multiplier) {\n" +
                "\t\tradius *= multiplier;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic int getX() {\n" +
                "\t\treturn x;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic int getY() {\n" +
                "\t\treturn y;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic int getRadius() {\n" +
                "\t\treturn radius;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic void setX(int x) {\n" +
                "\t\tthis.x = x;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic void setY(int y) {\n" +
                "\t\tthis.y = y;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic void setRadius(int radius) {\n" +
                "\t\tthis.radius = radius;\n" +
                "\t}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n" +
                "public class Application {\n" +
                "\n" +
                "\tpublic static void main (String [] args){\n" +
                "\t\tShape [] shapes = {\n" +
                "\t\t\t\tnew Circle(5,10,10, new LargeCircleDrawer()), \n" +
                "\t\t\t\tnew Circle(20,30,100, new SmallCircleDrawer())};\n" +
                "\t\t\n" +
                "\t\tfor (Shape next : shapes){\n" +
                "\t\t\tnext.draw();\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\n" +
                "}\n" +
                "// Output\n" +
                "Large circle center = 5,10 radius = 100\n" +
                "Small circle center = 20,30 radius = 25.0");
    }
    public void composite(){
        System.err.println(
                "interface Graphic {\n" +
                        "\n" +
                        "    public void print();\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "class CompositeGraphic implements Graphic {\n" +
                        "\n" +
                        "    private List<Graphic> mChildGraphics = new ArrayList<Graphic>();\n" +
                        "\n" +
                        "    public void print() {\n" +
                        "        for (Graphic graphic : mChildGraphics) {\n" +
                        "            graphic.print();\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    public void add(Graphic graphic) {\n" +
                        "        mChildGraphics.add(graphic);\n" +
                        "    }\n" +
                        "\n" +
                        "    public void remove(Graphic graphic) {\n" +
                        "        mChildGraphics.remove(graphic);\n" +
                        "    }\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "\n" +
                        "/** \"Leaf\" */\n" +
                        "class Ellipse implements Graphic {\n" +
                        "\n" +
                        "    public void print() {\n" +
                        "        System.out.println(\"Ellipse\");\n" +
                        "    }\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "\n" +
                        "public class Program {\n" +
                        "\n" +
                        "    public static void main(String[] args) {\n" +
                        "        Ellipse ellipse1 = new Ellipse();\n" +
                        "        Ellipse ellipse2 = new Ellipse();\n" +
                        "        Ellipse ellipse3 = new Ellipse();\n" +
                        "        Ellipse ellipse4 = new Ellipse();\n" +
                        "\n" +
                        "        //Initialize three composite graphics\n" +
                        "        CompositeGraphic graphic = new CompositeGraphic();\n" +
                        "        CompositeGraphic graphic1 = new CompositeGraphic();\n" +
                        "        CompositeGraphic graphic2 = new CompositeGraphic();\n" +
                        "\n" +
                        "        graphic1.add(ellipse1);\n" +
                        "        graphic1.add(ellipse2);\n" +
                        "        graphic1.add(ellipse3);\n" +
                        "\n" +
                        "        graphic2.add(ellipse4);\n" +
                        "\n" +
                        "        graphic.add(graphic1);\n" +
                        "        graphic.add(graphic2);\n" +
                        "\n" +
                        "        graphic.print();\n" +
                        "    }\n" +
                        "}");
    }
    public void decorator(){
        System.err.println("public interface InterfaceComponent {\n" +
                "\tvoid doOperation();\n" +
                "}\n" +
                "\n" +
                "class MainComponent implements InterfaceComponent {\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void doOperation() {\n" +
                "\t\tSystem.out.print(\"World!\");\n" +
                "\t}\t\n" +
                "}\n" +
                "\n" +
                "abstract class Pattern implements InterfaceComponent {\n" +
                "\tprotected InterfaceComponent component;\n" +
                "\t\n" +
                "\tpublic Pattern (InterfaceComponent c) {\n" +
                "\t\tcomponent = c;\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void doOperation() {\n" +
                "\t\tcomponent.doOperation();\n" +
                "\t}\n" +
                "\n" +
                "\tpublic void newOperation() {\n" +
                "\t\tSystem.out.println(\"Do Nothing\");\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "class PatternSpace extends Pattern {\n" +
                "\t\n" +
                "\tpublic PatternSpace(InterfaceComponent c) {\n" +
                "\t\tsuper(c);\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void doOperation() {\n" +
                "\t\tSystem.out.print(\" \");\n" +
                "\t\tsuper.doOperation();\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void newOperation() {\n" +
                "\t\tSystem.out.println(\"New space operation\");\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "class PatternComma extends Pattern {\n" +
                "\n" +
                "\tpublic PatternComma(InterfaceComponent c) {\n" +
                "\t\tsuper(c);\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void doOperation() {\n" +
                "\t\tSystem.out.print(\",\");\n" +
                "\t\tsuper.doOperation();\n" +
                "\t}\t\n" +
                "        \n" +
                "\t@Override\n" +
                "\tpublic void newOperation() {\n" +
                "\t\tSystem.out.println(\"New comma operation\");\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "class PatternHello extends Pattern {\n" +
                "\t\n" +
                "\tpublic PatternHello(InterfaceComponent c) {\n" +
                "\t\tsuper(c);\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void doOperation() {\n" +
                "\t\tSystem.out.print(\"Hello\");\n" +
                "\t\tsuper.doOperation();\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void newOperation() {\n" +
                "\t\tSystem.out.println(\"New hello operation\");\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "\t\n" +
                "\tpublic static void main (String... s) {\n" +
                "\t\tPattern c = new PatternHello(new PatternComma(new PatternSpace(new MainComponent())));\n" +
                "\t\tc.doOperation(); // Результат выполнения программы \"Hello, World!\"\n" +
                "\t    c.newOperation(); // New hello operation\n" +
                "    }\n" +
                "}");
    }
    public void facade(){
        System.err.println(
                "class CPU {\n" +
                        "    public void freeze() { ... }\n" +
                        "    public void jump(long position) { ... }\n" +
                        "    public void execute() { ... }\n" +
                        "}\n" +
                        "\n" +
                        "class Memory {\n" +
                        "    public void load(long position, byte[] data) { ... }\n" +
                        "}\n" +
                        "\n" +
                        "class HardDrive {\n" +
                        "    public byte[] read(long lba, int size) { ... }\n" +
                        "}\n" +
                        "\n" +
                        "class Computer {\n" +
                        "    private CPU cpu;\n" +
                        "    private Memory memory;\n" +
                        "    private HardDrive hardDrive;\n" +
                        "\n" +
                        "    public Computer() {\n" +
                        "        this.cpu = new CPU();\n" +
                        "        this.memory = new Memory();\n" +
                        "        this.hardDrive = new HardDrive();\n" +
                        "    }\n" +
                        "\n" +
                        "    public void startComputer() {\n" +
                        "        cpu.freeze();\n" +
                        "        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));\n" +
                        "        cpu.jump(BOOT_ADDRESS);\n" +
                        "        cpu.execute();\n" +
                        "    }\n" +
                        "}\n" +
                        "\n" +
                        "\n" +
                        "class Application {\n" +
                        "    public static void main(String[] args) {\n" +
                        "        Computer computer = new Computer();\n" +
                        "\t    computer.startComputer();\n" +
                        "    }\n" +
                        "}");
    }
    public void flyweight(){
        System.err.println("public abstract class EnglishCharacter {\n" +
                "\n" +
                "\tprotected char symbol;\n" +
                "\t\n" +
                "\tprotected int width;\n" +
                "\t\n" +
                "\tprotected int height;\n" +
                "\t\n" +
                "\tpublic abstract void printCharacter();\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "public class CharacterA extends EnglishCharacter {\n" +
                "\n" +
                "\tpublic CharacterA(){\n" +
                "\t\tsymbol = 'A';\n" +
                "\t\twidth = 10;\n" +
                "\t\theight = 20;\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void printCharacter() {\n" +
                "\t\tSystem.out.println(\"Symbol = \" + symbol + \" Width = \" + width + \" Height = \" + height);\n" +
                "\t}\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "public class CharacterB extends EnglishCharacter {\n" +
                "\n" +
                "\tpublic CharacterB(){\n" +
                "\t\tsymbol = 'B';\n" +
                "\t\twidth = 20;\n" +
                "\t\theight = 30;\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void printCharacter() {\n" +
                "\t\tSystem.out.println(\"Symbol = \" + symbol + \" Width = \" + width + \" Height = \" + height);\n" +
                "\t}\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "public class CharacterC extends EnglishCharacter {\n" +
                "\n" +
                "\tpublic CharacterC(){\n" +
                "\t\tsymbol = 'C';\n" +
                "\t\twidth = 40;\n" +
                "\t\theight = 50;\n" +
                "\t}\n" +
                "\t\n" +
                "\t@Override\n" +
                "\tpublic void printCharacter() {\n" +
                "\t\tSystem.out.println(\"Symbol = \" + symbol + \" Width = \" + width + \" Height = \" + height);\n" +
                "\t}\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "public class FlyweightFactory {\n" +
                "\n" +
                "\tprivate HashMap<Integer, EnglishCharacter> characters = new HashMap();\n" +
                "\t\n" +
                "\tpublic EnglishCharacter getCharacter(int characterCode){\n" +
                "\t\tEnglishCharacter character = characters.get(characterCode);\n" +
                "\t\tif (character == null){\n" +
                "\t\t\tswitch (characterCode){\n" +
                "\t\t\t\tcase 1 : {\n" +
                "\t\t\t\t\tcharacter = new CharacterA();\n" +
                "\t\t\t\t\tbreak;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\tcase 2 : {\n" +
                "\t\t\t\t\tcharacter = new CharacterB();\n" +
                "\t\t\t\t\tbreak;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\tcase 3 : {\n" +
                "\t\t\t\t\tcharacter = new CharacterC();\n" +
                "\t\t\t\t\tbreak;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t\tcharacters.put(characterCode, character);\n" +
                "\t\t}\n" +
                "\t\treturn character;\n" +
                "\t} \n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "\n" +
                "public class Application {\n" +
                "\n" +
                "\tpublic static void main (String [] args){\n" +
                "\t\tPatternFactory factory = new PatternFactory();\n" +
                "\t\t\n" +
                "\t\tint [] characterCodes = {1,2,3};\n" +
                "\t\tfor (int nextCode : characterCodes){\n" +
                "\t\t\tEnglishCharacter character = factory.getCharacter(nextCode);\n" +
                "\t\t\tcharacter.printCharacter();\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\n" +
                "}");
    }
    public void proxy(){
        System.err.println("public class Main {\n" +
                "\t\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tIMath p = new MathPattern();\n" +
                "\n" +
                "\t\t// Do the math\n" +
                "\t\tSystem.out.println(\"4 + 2 = \" + p.add(4, 2));\n" +
                "\t\tSystem.out.println(\"4 - 2 = \" + p.sub(4, 2));\n" +
                "\t\tSystem.out.println(\"4 * 2 = \" + p.mul(4, 2));\n" +
                "\t\tSystem.out.println(\"4 / 2 = \" + p.div(4, 2));\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "/**\n" +
                " * \"Subject\"\n" +
                " */\n" +
                "public interface IMath {\n" +
                "\n" +
                "\tpublic double add(double x, double y);\n" +
                "\n" +
                "\tpublic double sub(double x, double y);\n" +
                "\n" +
                "\tpublic double mul(double x, double y);\n" +
                "\n" +
                "\tpublic double div(double x, double y);\n" +
                "}\n" +
                "\n" +
                "/**\n" +
                " * \"Real Subject\"\n" +
                " */\n" +
                "public class Math implements IMath {\n" +
                "\n" +
                "\tpublic double add(double x, double y) {\n" +
                "\t\treturn x + y;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic double sub(double x, double y) {\n" +
                "\t\treturn x - y;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic double mul(double x, double y) {\n" +
                "\t\treturn x * y;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic double div(double x, double y) {\n" +
                "\t\treturn x / y;\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "public class MathPattern implements IMath {\n" +
                "\n" +
                "    private Math math;\n" +
                "\n" +
                "    public double add(double x, double y) {\n" +
                "        lazyInitMath();\n" +
                "        return math.add(x, y);\n" +
                "    }\n" +
                "\n" +
                "    public double sub(double x, double y) {\n" +
                "        lazyInitMath();\n" +
                "        return math.sub(x, y);\n" +
                "    }\n" +
                "\n" +
                "    public double mul(double x, double y) {\n" +
                "        lazyInitMath();\n" +
                "        return math.mul(x, y);\n" +
                "    }\n" +
                "\n" +
                "    public double div(double x, double y) {\n" +
                "        lazyInitMath();\n" +
                "        return math.div(x, y);\n" +
                "    }\n" +
                "\n" +
                "    private void lazyInitMath() {\n" +
                "        if (math == null) {\n" +
                "            math = new Math();\n" +
                "        }\n" +
                "    }\n" +
                "}");
    }

}
