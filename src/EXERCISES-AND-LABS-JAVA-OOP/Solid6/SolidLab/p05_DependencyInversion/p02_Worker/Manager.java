package Solid6.SolidLab.p05_DependencyInversion.p02_Worker;

public class Manager {
    Worker worker;

    public Manager(Worker worker) {
        this.worker = worker;
        this.worker.work();
    }
}
