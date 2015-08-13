package org.pnt.product.resource;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.lang.management.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Alexander on 30.07.2015.
 */
@Controller
@RequestMapping(value = "/system")
public class SystemResource {
//
//    public static void main(String[] args) {
//        List<VirtualMachineDescriptor> list = VirtualMachine.list();
//        for(VirtualMachineDescriptor descriptor: list) {
//            VirtualMachine vm = attach(descriptor);
//            if(vm != null) {
//                System.out.println(vm.id());
//                Properties agentProperties = getAgentProperties(vm);
//                Set<Object> objects = agentProperties.keySet();
//                for (Object object : objects) {
//                    System.out.println(object + ": " + agentProperties.get(object));
//                }
//            }
//
//        }
//    }
//
//    private static Properties getAgentProperties(VirtualMachine vm) {
//        Properties result = new Properties();
//        try {
//            result = vm.getSystemProperties();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    private static VirtualMachine attach(VirtualMachineDescriptor descriptor) {
//        VirtualMachine vm = null;
//        try {
//            vm = VirtualMachine.attach(descriptor);
//        } catch (AttachNotSupportedException e) {
////            e.printStackTrace();
//        } catch (IOException e) {
//  //          e.printStackTrace();
//        } finally {
//            dettach(vm);
//        }
//        return vm;
//    }
//
//    private static void dettach(VirtualMachine vm) {
//        try {
//            if(vm != null)vm.detach();
//        } catch (IOException e) {
//            //e.printStackTrace();
//        }
//    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public String getInfo() {

        StringBuilder sb = new StringBuilder();

        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for(VirtualMachineDescriptor vm: list) {
            System.out.println(vm.displayName());
        }
/*

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] allThreadIds = threadMXBean.getAllThreadIds();

        ManagementFactory.getMemoryMXBean();


        for(GarbageCollectorMXBean gcMb: ManagementFactory.getGarbageCollectorMXBeans()) {
        }

        for(MemoryPoolMXBean mpmx: ManagementFactory.getMemoryPoolMXBeans()) {

        }

        for(ThreadInfo ti: threadMXBean.dumpAllThreads(true, true)) {

        }

        sb.append(String.format("Size is %d", allThreadIds.length)).append("\n");

        for(long threadId: allThreadIds) {
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
            sb.append(threadInfo.getThreadName()).append("\n");
        }
*/
        return sb.toString();
    }
}
