/*
 * Copyright 2012 Steve Chaloner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import be.objectify.deadbolt.java.actions.Unrestricted;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.accessOk;

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
@Restrict(@Group("hurdy"))
public class UnrestrictedController extends Controller
{
    public F.Promise<Result> index()
    {
        return F.Promise.promise(() -> ok(accessOk.render()));
    }

    @Unrestricted
    public F.Promise<Result> unrestrictedWithinAConstrainedController()
    {
        return F.Promise.promise(() -> ok(accessOk.render()));
    }
}
