/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.telnet.nvt.iac.command;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khubla.telnet.nvt.NVT;

public class RemoteFlowControlIAICCommandHandlerImpl extends AbstractIACCommandHandler {
   /**
    * logger
    */
   static final Logger logger = LoggerFactory.getLogger(RemoteFlowControlIAICCommandHandlerImpl.class);

   @Override
   public void process(NVT nvt, int cmd) throws IOException {
      switch (cmd) {
         case NVT.IAC_COMMAND_DO:
            logger.info("Received IAC DO remoteflowcontrol");
            break;
         case NVT.IAC_COMMAND_DONT:
            logger.info("Received IAC DONT remoteflowcontrol");
            break;
         case NVT.IAC_COMMAND_WILL:
            logger.info("Received IAC WILL remoteflowcontrol");
            // we dont do flow control
            nvt.sendIACCommand(NVT.IAC_COMMAND_DONT, NVT.IAC_CODE_REMOTE_FLOW_CONTROL);
            break;
         case NVT.IAC_COMMAND_WONT:
            logger.info("Received IAC WONT remoteflowcontrol");
            break;
         case NVT.IAC_COMMAND_SB:
            logger.info("Received IAC SB remoteflowcontrol");
            break;
         default:
            logger.info("Received Unknown IAC Command:" + cmd);
      }
   }
}
