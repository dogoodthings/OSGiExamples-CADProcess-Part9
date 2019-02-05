package osgi.process;

import com.dscsag.plm.spi.interfaces.process.PluginProcess;
import com.dscsag.plm.spi.interfaces.process.PluginProcessService;

/**
 */
public class PluginProcessManager implements PluginProcessService
{
  @Override
  public PluginProcess getPluginProcess(String processName)
  {
    if("osgi.process.OptionDialogProcess".equalsIgnoreCase(processName))
    return new OptionDialogProcess();
    return null;
  }
}