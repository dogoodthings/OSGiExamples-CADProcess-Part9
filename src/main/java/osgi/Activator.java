package osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.dscsag.plm.spi.interfaces.process.PluginProcessService;

import osgi.process.PluginProcessManager;

/**
 * Activator to register provided services
 */
public class Activator implements BundleActivator
{
  public void start(BundleContext context) throws Exception
  {
    context.registerService(PluginProcessService.class, new PluginProcessManager(), null);
  }

  @Override
  public void stop(BundleContext bundleContext) throws Exception
  {
    //empty
  }
}