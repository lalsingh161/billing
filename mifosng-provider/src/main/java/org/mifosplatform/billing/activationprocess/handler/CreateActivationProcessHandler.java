/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mifosplatform.billing.activationprocess.handler;

import org.mifosplatform.billing.activationprocess.service.ActivationProcessWritePlatformService;
import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateActivationProcessHandler implements NewCommandSourceHandler {

    private final ActivationProcessWritePlatformService activationProcessWritePlatformService;

    @Autowired
    public CreateActivationProcessHandler(final ActivationProcessWritePlatformService activationProcessWritePlatformService) {
        this.activationProcessWritePlatformService = activationProcessWritePlatformService;
    }

    @Transactional
    @Override
    public CommandProcessingResult processCommand(final JsonCommand command) {

        return this.activationProcessWritePlatformService.activationProcess(command);
    }
}
