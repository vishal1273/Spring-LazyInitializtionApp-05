✅ Summary: Lazy Initialization of Spring Beans

Default behavior: Spring Beans are Eagerly initialized

Beans are created at application startup

Happens even if the bean is never used

🔍 What is Eager Initialization?

Spring creates all beans when the ApplicationContext starts

Any initialization logic (constructors, @PostConstruct) runs immediately

Advantage: Configuration errors are caught early at startup

💤 What is Lazy Initialization?

Bean is NOT created at startup

Bean is created only when it is first requested or used

@Lazy
@Component
class ClassB {
}

🧪 Example Behavior

Without @Lazy
→ Bean initialization logic runs during context startup

With @Lazy
→ Initialization runs only when context.getBean(ClassB.class) is called

⚙️ Key Points about @Lazy

Can be used on:

@Component

@Bean

@Configuration (makes all beans lazy)

Spring injects a lazy-resolution proxy instead of the real bean

Actual bean is created just before first use

✅ When Initialization Happens

Eager → At Spring context startup

Lazy → At first usage of the bean

⚠️ Recommendation

Eager initialization is recommended

Detects configuration issues early

Lazy initialization is rarely used

Useful when:

Bean has heavy or complex initialization

Startup time must be optimized

❗ Important Warning

With @Lazy:

Errors are NOT detected at startup

Errors occur at runtime when bean is accessed

📝 Final Takeaway

Use Eager initialization by default

Use @Lazy cautiously, only when necessary

Lazy beans trade startup safety for startup performance
