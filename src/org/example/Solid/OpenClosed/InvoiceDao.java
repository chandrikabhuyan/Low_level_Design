package org.example.Solid.OpenClosed;

//initially we had only saveToDB, but later on if we have to add a new method saveToFile then we should extend instead
// of modifying the original class

// Open for extension but closed for modification.
// This means that a system should improve easily by adding new code instead of changing the code core.
// This way, the core code always retains its unique identity, making it reusable.

interface InvoiceDaoNew {
    void save(String invoice);
}

class DBInvoiceDao implements InvoiceDaoNew{
    @Override
    public void save(String invoice) {
        //Save to DB
    }
}

class FileInvoiceDao implements InvoiceDaoNew{
    @Override
    public void save(String invoice) {
        //Save to File
    }
}




