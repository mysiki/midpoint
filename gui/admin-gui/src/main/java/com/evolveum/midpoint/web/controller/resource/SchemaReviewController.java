/*
 * Copyright (c) 2011 Evolveum
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1 or
 * CDDLv1.0.txt file in the source code distribution.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 *
 * Portions Copyrighted 2011 [name of copyright owner]
 */
package com.evolveum.midpoint.web.controller.resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.evolveum.midpoint.web.controller.wizard.WizardPage;

/**
 * 
 * @author lazyman
 * 
 */
@Controller("schemaReview")
@Scope("session")
public class SchemaReviewController extends WizardPage {

	private static final long serialVersionUID = 876495721840628204L;

	public SchemaReviewController() {
		super(ResourceWizard.PAGE_NAVIGATION_BASE + "/schemaReview.xhtml");
	}

	@Override
	public void cleanController() {
		// TODO Auto-generated method stub
	}
}
