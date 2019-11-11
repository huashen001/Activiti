/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.runtime.api.event.impl;

import java.util.Optional;

import org.activiti.api.process.model.events.BPMNMessageCancelledEvent;
import org.activiti.api.runtime.event.impl.BPMNMessageCancelledEventImpl;
import org.activiti.engine.delegate.event.ActivitiEntityEvent;

public class ToMessageCancelledConverter implements EventConverter<BPMNMessageCancelledEvent, ActivitiEntityEvent> {

    private BPMNMessageConverter bpmnMessageConverter;

    public ToMessageCancelledConverter(BPMNMessageConverter bpmnMessageConverter) {
        this.bpmnMessageConverter = bpmnMessageConverter;
    }

    @Override
    public Optional<BPMNMessageCancelledEvent> from(ActivitiEntityEvent internalEvent) {
        BPMNMessageCancelledEventImpl event = new BPMNMessageCancelledEventImpl(bpmnMessageConverter.convertToBPMNMessage(internalEvent));
        return Optional.of(event);
    }
}
