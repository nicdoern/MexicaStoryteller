/*
 * MexicaContextPanel.java
 *
 * Created on 30/07/2011, 11:43:16 PM
 */
package mexica.gui;

import javax.swing.JOptionPane;
import mexica.story.*;

/**
 *
 * @author Ivan Guerrero (UNAM, Mexico)
 */
public class MexicaContextPanel extends javax.swing.JPanel implements IStoryContextListener {
    private CharacterContextPanel[] panels;
    private Story story;
    
    public MexicaContextPanel() {
        initComponents();
    }
    
    /** Creates new form MexicaContextPanel */
    public MexicaContextPanel(Story story) {
        this.story = story;
        initComponents();
        loadContexts();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        characterContextPanel1 = new mexica.gui.CharacterContextPanel(story);
        characterContextPanel2 = new mexica.gui.CharacterContextPanel(story);
        characterContextPanel3 = new mexica.gui.CharacterContextPanel(story);
        characterContextPanel4 = new mexica.gui.CharacterContextPanel(story);
        characterContextPanel5 = new mexica.gui.CharacterContextPanel(story);
        characterContextPanel6 = new mexica.gui.CharacterContextPanel(story);
        characterContextPanel7 = new mexica.gui.CharacterContextPanel(story);
        characterContextPanel8 = new mexica.gui.CharacterContextPanel(story);

        setLayout(new java.awt.GridLayout(2, 4, 2, 2));
        add(characterContextPanel1);
        add(characterContextPanel2);
        add(characterContextPanel3);
        add(characterContextPanel4);
        add(characterContextPanel5);
        add(characterContextPanel6);
        add(characterContextPanel7);
        add(characterContextPanel8);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mexica.gui.CharacterContextPanel characterContextPanel1;
    private mexica.gui.CharacterContextPanel characterContextPanel2;
    private mexica.gui.CharacterContextPanel characterContextPanel3;
    private mexica.gui.CharacterContextPanel characterContextPanel4;
    private mexica.gui.CharacterContextPanel characterContextPanel5;
    private mexica.gui.CharacterContextPanel characterContextPanel6;
    private mexica.gui.CharacterContextPanel characterContextPanel7;
    private mexica.gui.CharacterContextPanel characterContextPanel8;
    // End of variables declaration//GEN-END:variables

    private void loadContexts() {
        panels = new CharacterContextPanel[] {
        characterContextPanel1, characterContextPanel2, characterContextPanel3, characterContextPanel4, 
        characterContextPanel5, characterContextPanel6, characterContextPanel7, characterContextPanel8};
        
        java.util.List<Avatar> avatars = story.getAvatarFactory().getActiveCharacters();
        int limit = Math.min(avatars.size(), 8);
        for (int i=0; i<limit; i++) {
            if (panels[i].getStory() == null)
                panels[i].setStory(story);
            panels[i].setOwner(avatars.get(i).getName());
            panels[i].loadData();
            panels[i].setVisible(true);
        }
        for (int i=limit; i<8; i++) {
            panels[i].setVisible(false);
        }
        
        this.validate();
        this.repaint();
        
        if (avatars.size() > 8)
            JOptionPane.showMessageDialog(this, "Only the first eight characters will be displayed", 
                    "Too many chacarters", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void notifyListener(ListType type) {
        switch (type) {
            case Characters:
                loadContexts();
                break;
        }
    }
    
    public void setStory(Story story) {
        this.story = story;
        loadContexts();
    }
}