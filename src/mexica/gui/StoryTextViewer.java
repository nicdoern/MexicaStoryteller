/*
 * StoryTextViewer.java
 *
 * Created on 1/08/2011, 01:01:57 PM
 */
package mexica.gui;

import java.util.List;
import java.util.Random;
import mexica.social.FinalStorySocialAnalyzer;
import mexica.story.ActionInstantiated;
import mexica.story.Story;
import mexica.story.TextInstantiated;

/**
 *
 * @author Ivan Guerrero (UNAM, Mexico)
 */
public class StoryTextViewer extends javax.swing.JDialog {
    private Story story;
    private List<ActionInstantiated> actions;
    private Random random;
    
    /** Creates new form StoryTextViewer */
    public StoryTextViewer(java.awt.Frame parent, boolean modal, Story story) {
        super(parent, modal);
        random = new Random();
        this.story = story;
        initComponents();
        loadStory();
    }
    
    /** Creates new form StoryTextViewer */
    public StoryTextViewer(java.awt.Frame parent, boolean modal, List<ActionInstantiated> actions) {
        super(parent, modal);
        random = new Random();
        this.actions = actions;
        initComponents();
        loadActions();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel1 = new mexica.gui.BackgroundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStory = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        bttnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mexica Story Generated");
        setLocationByPlatform(true);

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        txtStory.setColumns(20);
        txtStory.setEditable(false);
        txtStory.setLineWrap(true);
        txtStory.setRows(5);
        jScrollPane1.setViewportView(txtStory);

        lblTitle.setFont(new java.awt.Font("Pristina", 1, 24));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Story");

        bttnExit.setText("Exit");
        bttnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backgroundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)))
                    .addComponent(bttnExit, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backgroundPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(bttnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnExitActionPerformed
        setVisible(false);
    }//GEN-LAST:event_bttnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mexica.gui.BackgroundPanel backgroundPanel1;
    private javax.swing.JButton bttnExit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtStory;
    // End of variables declaration//GEN-END:variables

    private void loadStory() {
        FinalStorySocialAnalyzer socialAnalyzer = new FinalStorySocialAnalyzer(story);
        actions = socialAnalyzer.analyze();
        loadActions();
        
        //TODO: Perform final analysis of the story
//        FinalStoryAnalyzer analyzer = MexicaRepository.getInstance().getStoryAnalyzer();
//        for (TextInstantiated text : analyzer.generateFinalStory(story)) {
//            txtStory.append(text.getText());
//        }
    }

    private void loadActions() {
        for (ActionInstantiated action : actions) {
            List<TextInstantiated> texts = action.getTexts();
            TextInstantiated text = texts.get(random.nextInt(texts.size()));
            txtStory.append(text.getText() + " ");
        }
    }
}