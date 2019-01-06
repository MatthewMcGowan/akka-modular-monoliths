namespace UserService.Model
{
    public class User
    {
        public User(int id, string email, string firstName, string lastName)
        {
            Id = id;
            Email = email;
            FirstName = firstName;
            LastName = lastName;
        }

        public int Id { get; }
        public string Email { get; }
        public string FirstName { get; }
        public string LastName { get; }
    }
}
