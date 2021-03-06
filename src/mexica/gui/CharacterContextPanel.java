/*
 * CharacterContextPanel.java
 *
 * Created on 30/07/2011, 05:34:44 PM
 */
package mexica.gui;

import java.util.List;
import javax.swing.AbstractListModel;
import mexica.CharacterName;
import mexica.story.*;

/**
 * Class to display the facts for a given character
 * @author Ivan Guerrero (UNAM, Mexico)
 */
public class CharacterContextPanel extends javax.swing.JPanel {
    private CharacterName owner;
    private Story story;
    
    public CharacterContextPanel() {
        this(null);
    }
    
    public CharacterContextPanel(Story story) {
        this.story = story;
        initComponents();
        setVisible(true);
    }
    
    public void setStory(Story story) {
        this.story = story;
        initComponents();
        setVisible(true);
    }
    
    public Story getStory() {
        return story;
    }
        
    public void setOwner(CharacterName owner) {
        this.owner = owner;
    }
    
    public CharacterName getOwner() {
        return owner;
    }
    
    public void loadData() {
        Avatar avatar = story.getAvatarFactory().getAvatar(owner);
        final List<ConditionInstantiated> context = avatar.getContext().getFacts();
        listContext.setModel(new AbstractListModel() {

            @Override
            public int getSize() {
                return context.size();
            }

            @Override
            public Object getElementAt(int index) {
                return context.get(index);
            }
        });
        
        String text = avatar.toStringWithDate();
        if (!avatar.isAlive()) {
            text = "+ " + text;
            listContext.setEnabled(false);
        }
        else
            listContext.setEnabled(true);
        lblCharacterName.setText(text);
        lblLocation.setText(avatar.getCurrentPosition().toString());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listContext = new javax.swing.JList();
        lblCharacterName = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        listContext.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listContext.setSelectionBackground(new java.awt.Color(255, 255, 255));
        listContext.setSelectionForeground(java.awt.SystemColor.infoText);
        jScrollPane1.setViewportView(listContext);

        lblCharacterName.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCharacterName.setText("Character's Context");

        lblLocation.setText("at LOCATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCharacterName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLocation))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCharacterName)
                    .addComponent(lblLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCharacterName;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JList listContext;
    // End of variables declaration//GEN-END:variables
}
