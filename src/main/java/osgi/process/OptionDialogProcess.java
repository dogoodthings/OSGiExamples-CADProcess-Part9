package osgi.process;

import javax.swing.JOptionPane;

import com.dscsag.plm.spi.interfaces.process.DefaultPluginProcessContainer;
import com.dscsag.plm.spi.interfaces.process.PluginProcess;
import com.dscsag.plm.spi.interfaces.process.PluginProcessContainer;

/**
 * <description>
 *
 */
public class OptionDialogProcess implements PluginProcess
{
  /**
   *  message   the <code>Object</code> to display
   *  title     the title string for the dialog
   *  optionType an integer designating the options available
   *  on the dialog: <code>YES_NO_OPTION</code>,
   *  <code>YES_NO_CANCEL_OPTION</code>,
   *  or <code>OK_CANCEL_OPTION</code>
   *  messageType an integer designating the kind of message this is;
   *  primarily used to determine the icon from the pluggable
   *  Look and Feel: <code>ERROR_MESSAGE</code>,
   *  <code>INFORMATION_MESSAGE</code>,
   *  <code>WARNING_MESSAGE</code>,
   *  <code>QUESTION_MESSAGE</code>,
   *  or <code>PLAIN_MESSAGE</code>
   *
   *  s. JOptionPane.showConfirmDialog(null, message, title, optionType, messageType);
   *
   *
   * @param pluginProcessContainer
   * @return JOptionPane.CANCEL
   * @throws Exception
   */

  @Override
  public PluginProcessContainer execute(PluginProcessContainer pluginProcessContainer) throws Exception
  {
    DefaultPluginProcessContainer resultContainer = new DefaultPluginProcessContainer();
    resultContainer.setParameter("DIALOG_USER_RESPONSE",JOptionPane.CANCEL_OPTION);
    try
    {
      Object message = pluginProcessContainer.getParameter("DIALOG_MESSAGE");
      String title = String.valueOf(pluginProcessContainer.getParameter("DIALOG_TITLE"));
      int optionType = Integer.parseInt(String.valueOf(pluginProcessContainer.getParameter("DIALOG_OPTION_TYPE")));
      int messageType = Integer.parseInt(String.valueOf(pluginProcessContainer.getParameter("DIALOG_MESSAGE_TYPE")));
      int result = JOptionPane.showConfirmDialog(null, message, title, optionType, messageType);
      resultContainer.setParameter("DIALOG_USER_RESPONSE", result);
    }
    finally
    {
      //
    }
    return resultContainer;
  }
}