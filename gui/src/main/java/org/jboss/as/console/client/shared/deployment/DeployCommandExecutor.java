/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved. 
 * See the copyright.txt in the distribution for a 
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use, 
 * modify, copy, or redistribute it subject to the terms and conditions 
 * of the GNU Lesser General Public License, v. 2.1. 
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details. 
 * You should have received a copy of the GNU Lesser General Public License, 
 * v.2.1 along with this distribution; if not, write to the Free Software 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */

package org.jboss.as.console.client.shared.deployment;

import org.jboss.as.console.client.shared.model.DeploymentRecord;

/**
 * Implementers of this interface carry out sending the actual command to the
 * server.
 *
 * @author Stan Silvert <ssilvert@redhat.com> (C) 2011 Red Hat Inc.
 */
public interface DeployCommandExecutor {
  /**
   * Toggle the enabled/disabled flag on the deployment.
   * 
   * @param record The deployment.
   */
  public void enableDisableDeployment(DeploymentRecord record);
  
  /**
   * Remove a deployment form its server group.  The record must contain
   * the server group it is to be removed from.
   * 
   * @param record The deployment.
   * @throws UnsupportedOperationException if in standalone mode.
   */
  public void removeDeploymentFromGroup(DeploymentRecord record);
  
  /**
   * Add the deployment to a server group.
   * 
   * @param selectedGroup The selected server group.
   * @param record The deployment.
   * @throws UnsupportedOperationException if in standalone mode.
   */
  public void addToServerGroup(String selectedGroup, DeploymentRecord record);
  
  /**
   * Remove a deployment from the server.
   * 
   * @param record The deployment.
   */
  public void removeContent(DeploymentRecord record);
  
  /**
   * Get the currently selected server group.
   * 
   * @return The server group name or <code>null</code> if no server group
   *         is selected.
   * @throws UnsupportedOperationException if in standalone mode.
   */
  public String getSelectedServerGroup();
}
