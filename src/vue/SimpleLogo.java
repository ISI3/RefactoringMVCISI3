package vue;

import controleur.Controleur;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import modele.Couleur;
import modele.Tortue;

public class SimpleLogo extends JFrame implements Observer {

    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);

    private FeuilleDessin feuille;
    private Tortue courante;
    private JTextField inputValue;
    private Controleur controleur;
    private JComboBox colorList;

    private JTextField inputName;

    public FeuilleDessin getFeuille() {
        return feuille;
    }

    public void quitter() {
        System.exit(0);
    }

    public SimpleLogo(Controleur controleur) {
        super("Jeu de tortues");
        this.controleur = controleur;
        this.courante = controleur.getJeu().getTortueCourante();
        this.logoInit();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        addMouseListener(controleur);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void logoInit() {
        getContentPane().setLayout(new BorderLayout(10, 10));

        // Boutons
        JToolBar toolBar = new JToolBar();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        getContentPane().add(buttonPanel, "North");

        addButton(toolBar, "Effacer", "Nouveau dessin", "/icons/index.png");

        toolBar.setFloatable(false);
        toolBar.add(Box.createRigidArea(HGAP));
        inputValue = new JTextField("45", 5);
        toolBar.add(inputValue);
        addButton(toolBar, "Avancer", "Avancer 50", null);
        addButton(toolBar, "Droite", "Droite 45", null);
        addButton(toolBar, "Gauche", "Gauche 45", null);

        // Create the combo box
        toolBar.add(Box.createRigidArea(HGAP));
        JLabel colorLabel = new JLabel("   Couleur: ");
        toolBar.add(colorLabel);
        colorList = new JComboBox(Couleur.colorStrings);
        toolBar.add(colorList);

        JLabel nom = new JLabel(" Nom : ");
        toolBar.add(nom);
        setInputName(new JTextField(5));
        toolBar.add(getInputName());

        addButton(toolBar, "Ajouter", "Ajouter Tortue", null);

        addButton(toolBar, "Jouer", "Jouer partie", null);

        // Menus
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);    // on installe le menu bar
        JMenu menuFile = new JMenu("File"); // on installe le premier menu
        menubar.add(menuFile);

        addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
        addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);

        JMenu menuCommandes = new JMenu("Commandes"); // on installe le premier menu
        menubar.add(menuCommandes);
        addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
        addMenuItem(menuCommandes, "Droite", "Droite", -1);
        addMenuItem(menuCommandes, "Gauche", "Gauche", -1);

        JMenu menuHelp = new JMenu("Aide"); // on installe le premier menu
        menubar.add(menuHelp);
        addMenuItem(menuHelp, "Aide", "Help", -1);
        addMenuItem(menuHelp, "A propos", "About", -1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        feuille = new FeuilleDessin();
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(800, 600));
        feuille.setPreferredSize(new Dimension(800, 600));

        getContentPane().add(feuille, "Center");

        // Deplacement de la tortue au centre de la feuille
        feuille.addTortue(new VueTortue(this.getCourante()));
        pack();
        setVisible(true);
    }

    public String getInputValue() {
        String s = inputValue.getText();
        return (s);
    }

    public void effacer() {
        feuille.reset();
        feuille.repaint();
    }

    //utilitaires pour installer des boutons et des menus
    public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton) p.add(new JButton(name));
        } else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon(u);
                b = (JButton) p.add(new JButton(im));
            } else {
                b = (JButton) p.add(new JButton(name));
            }
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0, 0, 0, 0));
        b.addActionListener(controleur);
    }

    public void addMenuItem(JMenu m, String label, String command, int key) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(label);
        m.add(menuItem);

        menuItem.setActionCommand(command);
        menuItem.addActionListener(controleur);
        if (key > 0) {
            if (key != KeyEvent.VK_DELETE) {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
            } else {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.getFeuille().repaint();
    }

    public JTextField getInputName() {
        return inputName;
    }

    public void setInputName(JTextField inputName) {
        this.inputName = inputName;
    }

    public JComboBox getColorList() {
        return colorList;
    }

    public void setColorList(JComboBox colorList) {
        this.colorList = colorList;
    }

    public Tortue getCourante() {
        return courante;
    }

    public void setCourante(Tortue courante) {
        this.courante = courante;
    }
}
