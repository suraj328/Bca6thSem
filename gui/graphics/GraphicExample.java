/**
 * public void paintComponent(Graphics g)
 * {
 *      var g2 = (Graphics2D) g;
 *      //draw a rectangle
 *      double leftX = 100;
 *      double topY = 100;
 *      double width = 200;
 *      double height = 150;
 * 
 *      var rect = new Rectangle2D.Double(leftX,topY,width,height);
 *      g2.draw(rect);
 * 
 *      //draw the enclosed ellispse
 *      var ellipse = new ellipse
 *      ellispse.setFrame(rect);
 *      g2.draw(ellipse);
 *      
 * 
 *      //draw a diagonal line
 *      g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height))
 * 
 *      //draw a circle with the same center
 *      double centerX = rect.getCenterX();
 *      double centerX = rect.getCenterY();
 *      double radius = 150;
 * 
 *      var circle = new Ellipse2D.Double();
 *      circle.setFrameFromCenter(centerX,CenterY,centerX+radius,g2.draw(circle));
 *  
 * }
 * 
 * public Dimenson  getPreferredSize()
 * {
 *     return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
 * }
 */
