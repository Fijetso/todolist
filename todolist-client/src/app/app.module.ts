import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { NavigationComponent } from "./navigation/navigation.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import { Router, Routes, RouterModule } from "@angular/router";
import { TodoListComponent } from "./todo-list/todo-list.component";
import { FormsModule } from "@angular/forms";

const appRoutes: Routes = [
  {
    path: "todolist",
    component: TodoListComponent
  },
  {
    path: "",
    component: TodoListComponent,
    pathMatch: "full"
  },
  {
    path: "**",
    component: NotFoundComponent
  }
];
@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    NotFoundComponent,
    TodoListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(appRoutes, { enableTracing: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
