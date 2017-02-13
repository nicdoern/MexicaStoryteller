package mexica.gui;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import mexica.MexicaParameters;
import mexica.action.*;
import mexica.core.*;
import mexica.story.*;
import mexica.story.IStoryContextListener.ListType;
import mexica.story.filter.StoryFilterException;
import mexica.tools.*;

/**
 * Main window of the Mexica story generator app
 * @author Ivan Guerrero (UNAM, Mexico)
 */
public class MexicaStoryGenerator extends javax.swing.JFrame {
    private boolean engagementMode;
    private MexicaReflectionGUI reflectionGUI = null;
    private Story story;
    
    /** Creates new form MexicaStoryGenerator */
    public MexicaStoryGenerator(Story story) {
        this.story = story;
        initComponents();
        setListeners();
        addPopupMenu();
        getContentPane().setBackground(getBackground());
    }

    private void setListeners() {
        story.addStoryContextListener(listActions, ListType.Actions);
        story.addStoryContextListener(listStory, ListType.Story);
        story.addStoryContextListener(panelContext, ListType.Characters);
        
        reflectionGUI = new MexicaReflectionGUI(this, true, story);
    }
    
    private void addPopupMenu() {
        final JPopupMenu popupFulfillCondition = new JPopupMenu();
        JMenuItem menuAddAction = new JMenuItem("Remove action");
        popupFulfillCondition.add(menuAddAction);
        menuAddAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuRemoveActionActionPerformed(e);
            }
        });
        
        listActions.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            public void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupFulfillCondition.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    /**
     * Method called when Remove action is clicked inside the popup menu for actions
     * @param e 
     */
    private void menuRemoveActionActionPerformed(ActionEvent e) {
        try {
            ActionInstantiated action = (ActionInstantiated)listActions.getSelectedValue();
            if (action != null) {
                story.removeAction(action);
            }
            else {
                JOptionPane.showMessageDialog(this, "Please select a condition to fulfill first", "Select a Missing Condition", JOptionPane.ERROR_MESSAGE);
            }
        } catch (InvalidCharacterException | DeadAvatarException | StoryFilterException icle) {
            JOptionPane.showMessageDialog(this, "Error while removing action", icle.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spStory = new javax.swing.JScrollPane();
        panelElements = new javax.swing.JPanel();
        lblActions = new javax.swing.JLabel();
        lblStory = new javax.swing.JLabel();
        spListStory = new javax.swing.JScrollPane();
        listStory = new mexica.gui.JListUpdateable(story);
        jScrollPane1 = new javax.swing.JScrollPane();
        listActions = new mexica.gui.JListUpdateable(story);
        lblCharacterContext = new javax.swing.JLabel();
        panelContext = new mexica.gui.MexicaContextPanel(story);
        menuBar = new javax.swing.JMenuBar();
        menuActions = new javax.swing.JMenu();
        menuItemRestart = new javax.swing.JMenuItem();
        menuItemDefaultPosition = new javax.swing.JMenuItem();
        menuItemGenerateStory = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem(new mexica.action.ViewStoryLogAction(this, story));
        menuExit = new javax.swing.JMenuItem();
        menuER = new javax.swing.JMenu();
        engagementStepMenu = new javax.swing.JMenuItem(new EngagementAction(story));
        menuItemEngagement = new javax.swing.JMenuItem();
        reflectionStepMenu = new javax.swing.JMenuItem(new ReflectionAction(story));
        menuItemReflection = new javax.swing.JMenuItem();
        ERStepMenu = new javax.swing.JMenuItem(new ERStepAction(story));
        jMenuItem1 = new javax.swing.JMenuItem(new CreateStoryAction(story));
        menuSlant = new javax.swing.JMenu();
        slantOutputMenu = new javax.swing.JMenuItem(new SlantOutputAction(story));
        menuHelp = new javax.swing.JMenu();
        menuItemAbout = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mexica Story Generator");
        setBackground(new java.awt.Color(204, 212, 200));
        setLocationByPlatform(true);

        panelElements.setBackground(new java.awt.Color(204, 212, 200));
        panelElements.setPreferredSize(new java.awt.Dimension(1248, 703));

        lblActions.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblActions.setText("Actions");

        lblStory.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblStory.setText("Story text");

        listStory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spListStory.setViewportView(listStory);

        jScrollPane1.setViewportView(listActions);

        lblCharacterContext.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCharacterContext.setText("Characters' context");

        panelContext.setBackground(new java.awt.Color(204, 212, 200));

        javax.swing.GroupLayout panelElementsLayout = new javax.swing.GroupLayout(panelElements);
        panelElements.setLayout(panelElementsLayout);
        panelElementsLayout.setHorizontalGroup(
            panelElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelElementsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCharacterContext)
                    .addGroup(panelElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelElementsLayout.createSequentialGroup()
                            .addGroup(panelElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblStory)
                                .addComponent(spListStory, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblActions)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(panelContext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(208, 208, 208))
        );
        panelElementsLayout.setVerticalGroup(
            panelElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelElementsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStory)
                    .addComponent(lblActions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(spListStory, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblCharacterContext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        spStory.setViewportView(panelElements);

        menuBar.setBackground(getBackground());

        menuActions.setBackground(getBackground());
        menuActions.setText("Actions");

        menuItemRestart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItemRestart.setBackground(getBackground());
        menuItemRestart.setText("Restart story");
        menuItemRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRestartActionPerformed(evt);
            }
        });
        menuActions.add(menuItemRestart);

        menuItemDefaultPosition.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuItemDefaultPosition.setBackground(getBackground());
        menuItemDefaultPosition.setText("Set default position");
        menuItemDefaultPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDefaultPositionActionPerformed(evt);
            }
        });
        menuActions.add(menuItemDefaultPosition);

        menuItemGenerateStory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGenerateStory.setBackground(getBackground());
        menuItemGenerateStory.setText("Retrieve story text");
        menuItemGenerateStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGenerateStoryActionPerformed(evt);
            }
        });
        menuActions.add(menuItemGenerateStory);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("View story log");
        menuActions.add(jMenuItem2);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuActions.add(menuExit);

        menuBar.add(menuActions);

        menuER.setText("E-R");

        engagementStepMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        engagementStepMenu.setText("Automatic engagement");
        menuER.add(engagementStepMenu);

        menuItemEngagement.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemEngagement.setBackground(getBackground());
        menuItemEngagement.setText("Manual engagement");
        menuItemEngagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEngagementActionPerformed(evt);
            }
        });
        menuER.add(menuItemEngagement);

        reflectionStepMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        reflectionStepMenu.setText("Automatic reflection");
        menuER.add(reflectionStepMenu);

        menuItemReflection.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuItemReflection.setBackground(getBackground());
        menuItemReflection.setText("Manual reflection");
        menuItemReflection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReflectionActionPerformed(evt);
            }
        });
        menuER.add(menuItemReflection);

        ERStepMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        ERStepMenu.setText("Automatic E-R cycle");
        menuER.add(ERStepMenu);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Create Story");
        menuER.add(jMenuItem1);

        menuBar.add(menuER);

        menuSlant.setText("Slant");

        slantOutputMenu.setText("Generate output");
        menuSlant.add(slantOutputMenu);

        menuBar.add(menuSlant);

        menuHelp.setBackground(getBackground());
        menuHelp.setText("Help");

        menuItemAbout.setBackground(getBackground());
        menuItemAbout.setText("About Mexica");
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        menuHelp.add(menuItemAbout);

        helpMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        helpMenu.setText("Help");
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuActionPerformed(evt);
            }
        });
        menuHelp.add(helpMenu);

        menuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuItemExit.setBackground(getBackground());
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuHelp.add(menuItemExit);

        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spStory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spStory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEngagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEngagementActionPerformed
        MexicaEngagementGUI instance = new MexicaEngagementGUI(this, true, story);
        instance.setVisible(true);
    }//GEN-LAST:event_menuItemEngagementActionPerformed

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        JOptionPane.showMessageDialog(this,
                "Developed by Iván Guerrero\nRevised by Rafael Pérez y Pérez\nUNAM, Mexico 2013",
                "Mexica",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menuItemAboutActionPerformed

    private void menuItemReflectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReflectionActionPerformed
        if (story.getDefaultPosition() != Position.NotDefined) {
            reflectionGUI.setTensionGraphs();
            reflectionGUI.setLocationByPlatform(true);
            boolean illogicalActions = MexicaParameters.ENABLE_ILLOGICAL_ACTIONS;
            reflectionGUI.setVisible(true);
            MexicaParameters.ENABLE_ILLOGICAL_ACTIONS = illogicalActions;
        }
        else
            JOptionPane.showMessageDialog(this, "Please select a default position first", "Select a Default Position", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_menuItemReflectionActionPerformed

    private void menuItemRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRestartActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "This will remove all the elements in the story",
                "Restart Story", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            MexicaConfiguration config = new MexicaConfiguration();
            config.setLocationByPlatform(true);
            config.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_menuItemRestartActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?",
                "End program execution", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemDefaultPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDefaultPositionActionPerformed
        Object pos = JOptionPane.showInputDialog(this, "Select a Default Position: ", "Set Default Position",
                    JOptionPane.QUESTION_MESSAGE, null,
                    PositionFactory.getInstance().getAvailablePositions().toArray(),
                    story.getAvatarFactory().getDefaultPosition());

        if (pos instanceof Position) {
            story.getAvatarFactory().setDefaultPosition((Position)pos);
        }
    }//GEN-LAST:event_menuItemDefaultPositionActionPerformed

    private void menuItemGenerateStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGenerateStoryActionPerformed
        StoryTextViewer viewer = new StoryTextViewer(this, true, story);
        viewer.setVisible(true);
    }//GEN-LAST:event_menuItemGenerateStoryActionPerformed

    private void helpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuActionPerformed
        MexicaHelpViewerGUI help = new MexicaHelpViewerGUI(this, false);
        help.setLocationRelativeTo(this);
        help.setVisible(true);
    }//GEN-LAST:event_helpMenuActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    public void setMode(boolean engagementMode) {
        this.engagementMode = engagementMode;
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    MexicaStoryGenerator storyGen = new MexicaStoryGenerator(new Story());
                    storyGen.setLocationByPlatform(true);
                    storyGen.setVisible(true);
                    storyGen.setExtendedState(storyGen.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                }
            });
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ERStepMenu;
    private javax.swing.JMenuItem engagementStepMenu;
    private javax.swing.JMenuItem helpMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActions;
    private javax.swing.JLabel lblCharacterContext;
    private javax.swing.JLabel lblStory;
    private mexica.gui.JListUpdateable listActions;
    private mexica.gui.JListUpdateable listStory;
    private javax.swing.JMenu menuActions;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuER;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemDefaultPosition;
    private javax.swing.JMenuItem menuItemEngagement;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemGenerateStory;
    private javax.swing.JMenuItem menuItemReflection;
    private javax.swing.JMenuItem menuItemRestart;
    private javax.swing.JMenu menuSlant;
    private mexica.gui.MexicaContextPanel panelContext;
    private javax.swing.JPanel panelElements;
    private javax.swing.JMenuItem reflectionStepMenu;
    private javax.swing.JMenuItem slantOutputMenu;
    private javax.swing.JScrollPane spListStory;
    private javax.swing.JScrollPane spStory;
    // End of variables declaration//GEN-END:variables
}
